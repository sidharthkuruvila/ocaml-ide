package org.ocaml.ide.mli

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

/**
 * Created by sidharthkuruvila on 17/05/16.
 */
class MliFile (viewProvider: FileViewProvider) : PsiFileBase(viewProvider, OcamlInterfaceLanguage) {
    override fun getFileType(): FileType {
        return MliFileType
    }
}