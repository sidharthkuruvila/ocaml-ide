package org.ocaml.ide.project

import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.module.ModuleTypeManager
import org.ocaml.lang.OcamlIcons
import javax.swing.Icon

/**
 * Created by sidharthkuruvila on 18/05/16.
 */
class OcamlModuleType : ModuleType<OcamlModuleBuilder>(ID) {
    companion object {
        val ID = "OcamlModuleType"

        fun getInstance(): OcamlModuleType {
            return ModuleTypeManager.getInstance().findByID(ID) as OcamlModuleType
        }
    }

    override fun getName(): String {
        return "Ocaml Module"
    }

    override fun getDescription(): String {
        return "Module for ocaml projects"
    }

    override fun createModuleBuilder(): OcamlModuleBuilder {
        return OcamlModuleBuilder()
    }

    override fun getNodeIcon(isOpened: Boolean): Icon {
        return OcamlIcons.CAMEL_ICON_FILE
    }
}
