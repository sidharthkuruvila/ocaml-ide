package org.ocaml.ide.runconfig.form

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory
import com.intellij.openapi.options.ConfigurationException
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.TextFieldWithBrowseButton
import org.ocaml.ide.runconfig.OcamlFileRunConfiguration

import javax.swing.*

/**
 * Created by sidharthkuruvila on 17/05/16.
 */
class OcamlRunConfigurationForm(project: Project) : SettingsEditor<OcamlFileRunConfiguration>() {
    private lateinit var mlFilePath: TextFieldWithBrowseButton
    private lateinit var root: JPanel

    init {
        mlFilePath!!.addBrowseFolderListener("Something", "Something", project,
                FileChooserDescriptorFactory.createSingleFileDescriptor("ml"))
    }

    override fun resetEditorFrom(s: OcamlFileRunConfiguration) {
        mlFilePath!!.text = s.mlFilePath
    }

    @Throws(ConfigurationException::class)
    override fun applyEditorTo(s: OcamlFileRunConfiguration) {

        s.mlFilePath = mlFilePath!!.text
    }

    override fun createEditor(): JComponent {
        return root
    }
}
