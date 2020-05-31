package org.ocaml.ide.project

import com.intellij.ide.util.projectWizard.ModuleBuilder
import com.intellij.openapi.module.ModuleType
import com.intellij.openapi.roots.ModifiableRootModel
import com.intellij.openapi.util.io.FileUtil
import com.intellij.openapi.vfs.LocalFileSystem

/**
 * Created by sidharthkuruvila on 18/05/16.
 */
class OcamlModuleBuilder : ModuleBuilder() {
    override fun getModuleType(): ModuleType<*>? {
        return OcamlModuleType.getInstance()
    }

    override fun setupRootModel(modifiableRootModel: ModifiableRootModel) {
        val path = contentEntryPath!!
        val sourceRoot = LocalFileSystem.getInstance().refreshAndFindFileByPath(FileUtil.toSystemIndependentName(path))!!;
        val ce = doAddContentEntry(modifiableRootModel)!!
        ce.addSourceFolder(sourceRoot, false)
    }
}
