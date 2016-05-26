package org.ocaml.lang

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

/**
 * Created by sidharthkuruvila on 27/04/16.
 */

class MlFileType : LanguageFileType(OcamlLanguage.INSTANCE) {

    companion object {
        val INSTANCE = MlFileType()

    }
    override fun getDescription(): String {
        return "Ocaml source file"
    }

    override fun getDefaultExtension(): String {
        return "ml"
    }


    override fun getName(): String {
        return "Ocaml File"
    }

    override fun getIcon(): Icon? {
        return OcamlIcons.MODULE_ICON_FILE
    }

}