package org.ocaml.sexp

import com.intellij.openapi.fileTypes.LanguageFileType
import org.ocaml.lang.OcamlIcons
import org.ocaml.lang.OcamlLanguage
import javax.swing.Icon

class SexpFileType : LanguageFileType(OcamlLanguage.INSTANCE) {

    companion object {
        val INSTANCE = SexpFileType()

    }
    override fun getDescription(): String {
        return "Ocaml sexp"
    }

    override fun getDefaultExtension(): String {
        return "sexp"
    }


    override fun getName(): String {
        return "Sexp File"
    }

    override fun getIcon(): Icon? {
        return OcamlIcons.MODULE_ICON_FILE
    }

}