package org.ocaml.jbuild.parser

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider
import org.ocaml.jbuild.JbuilderFileType
import org.ocaml.jbuild.JbuilderLanguage

class JbuilderPsiFileRoot(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, JbuilderLanguage) {
    override fun getFileType(): FileType {
        return JbuilderFileType.INSTANCE
    }
}