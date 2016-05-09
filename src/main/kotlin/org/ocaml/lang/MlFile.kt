package org.ocaml.lang

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

/**
 * Created by sidharthkuruvila on 05/05/16.
 */
class MlFile(viewProvider: FileViewProvider) : PsiFileBase(viewProvider, OcamlLanguage.INSTANCE) {
    override fun getFileType(): FileType {
        return MlFileType.INSTANCE
    }
}