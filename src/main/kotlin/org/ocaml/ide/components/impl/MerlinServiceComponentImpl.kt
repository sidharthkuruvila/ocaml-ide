package org.ocaml.ide.components.impl

import com.intellij.openapi.editor.EditorFactory
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiFile
import org.ocaml.ide.components.MerlinServiceComponent
import org.ocaml.ide.components.MerlinServiceDocumentListener
import org.ocaml.merlin.CompletionEntry
import org.ocaml.merlin.Merlin
import org.ocaml.merlin.MerlinError
import org.ocaml.merlin.Position

/**
 * Created by sidharthkuruvila on 24/05/16.
 */

class MerlinServiceComponentImpl : MerlinServiceComponent {

    val merlin = Merlin.newInstance()
    val msdl = MerlinServiceDocumentListener(merlin)

    override fun getComponentName(): String {
        return "ocaml.merlinservice"
    }

    override fun disposeComponent() {
        EditorFactory.getInstance().eventMulticaster.removeDocumentListener(msdl)
    }

    override fun initComponent() {
        EditorFactory.getInstance().eventMulticaster.addDocumentListener(msdl)
    }

    override fun errors(file: PsiFile): List<MerlinError> {
        reloadFileIfModified(file)
        return merlin.errors(file.virtualFile.canonicalPath!!)
    }

    override fun completions(file: PsiFile, prefix: String, position: Position): List<CompletionEntry> {
        reloadFileIfModified(file)
        return merlin.complete(file.virtualFile.canonicalPath!!, prefix, position).entries
    }

    private fun reloadFileIfModified(file: PsiFile) {
        val doc = PsiDocumentManager.getInstance(file.project).getCachedDocument(file)
        val filename = file.virtualFile.canonicalPath!!
        if(doc == null || doc.getUserData(MerlinServiceDocumentListener.DOCUMENT_CHANGED)?: true) {
            merlin.seekExact(filename, Position(1, 0))
            merlin.drop(filename)
            merlin.tellSource(filename, file.text)
            doc?.putUserData(MerlinServiceDocumentListener.DOCUMENT_CHANGED, false)
        }
    }
}