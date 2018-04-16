package org.ocaml.jbuild

import com.intellij.openapi.fileTypes.LanguageFileType
import org.ocaml.lang.OcamlIcons
import javax.swing.Icon

class JbuilderFileType : LanguageFileType(JbuilderLanguage) {

    companion object {
        val INSTANCE = JbuilderFileType()

    }
    override fun getDescription(): String {
        return "Jbuilder config"
    }

    override fun getDefaultExtension(): String {
        return "jbuild"
    }


    override fun getName(): String {
        return "Jbuilder File"
    }

    override fun getIcon(): Icon? {
        return OcamlIcons.MODULE_ICON_FILE
    }

}