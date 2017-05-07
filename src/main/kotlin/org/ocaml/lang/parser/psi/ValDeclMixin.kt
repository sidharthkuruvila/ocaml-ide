package org.ocaml.lang.parser.psi

import com.intellij.extapi.psi.ASTWrapperPsiElement
import com.intellij.lang.ASTNode
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiNamedElement
import com.intellij.util.IncorrectOperationException
import org.jetbrains.annotations.NonNls

abstract class ValDeclMixin(node: ASTNode) : ASTWrapperPsiElement(node), ValDecl, PsiNamedElement {
    override fun getName(): String? {
        return this.text
    }


    @Throws(IncorrectOperationException::class)
    override fun setName(@NonNls name: String): PsiElement {
        return this
    }
}
