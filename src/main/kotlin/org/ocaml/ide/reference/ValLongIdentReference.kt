package org.ocaml.ide.reference

import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.util.TextRange
import com.intellij.openapi.vfs.LocalFileSystem
import com.intellij.psi.*
import org.ocaml.ide.components.MerlinServiceComponent
import org.ocaml.lang.parser.psi.ValLongident
import org.ocaml.merlin.*
import org.ocaml.util.LineNumbering
import java.io.File

class ValLongIdentReference(element: ValLongident) : PsiReferenceBase<ValLongident>(element) {
//    val merlinService = ApplicationManager.getApplication().getComponent(MerlinServiceComponent::class.java)

    init {
        val tr = TextRange(0, element.textRange.endOffset - element.textRange.startOffset)
        rangeInElement = tr
    }

    private val merlinService = this.element.containingFile.project.getService(MerlinServiceComponent::class.java)

    override fun getVariants(): Array<Any> {
        return emptyArray()
    }

    override fun resolve(): PsiElement? {
        val psiFile = this.element.containingFile
        val ln = LineNumbering(psiFile.text)
        val offset = element.valIdent.textOffset
        val location = merlinService.locate(psiFile, ln.position(offset))

        return when (location) {
            LocatedAtPosition -> element
            is LocateFailed -> null
            is LocatedInCurrentFile ->
                    elementLocatedInPsiFile(psiFile, location.pos)
            is Located ->
                    elementLocated(location.file, location.pos)
            else ->
                    throw IllegalStateException("Got unexpected location result $location")
        }

    }

    private fun elementLocated(file: String, pos: Position): PsiElement? {
        val project = element.project
        val vfile = LocalFileSystem.getInstance().findFileByIoFile(File(file)) ?: return null
        val psiFile = PsiManager.getInstance(project).findFile(vfile) ?: return null
        val el = elementLocatedInPsiFile(psiFile, pos) ?: return null
        return findNamedParent(el)
    }

    tailrec fun findNamedParent(el: PsiElement): PsiElement? {
        val nel =  el.parent
        if(nel == null || nel is PsiNamedElement) {
            return nel
        } else {
            return findNamedParent(nel)
        }
    }

    private fun elementLocatedInPsiFile(psiFile: PsiFile, pos: Position): PsiElement? {
        val ln = LineNumbering(psiFile.text)
        val index = ln.index(pos)
        return psiFile.findElementAt(index)
    }

}