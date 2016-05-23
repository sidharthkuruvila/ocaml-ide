package org.ocaml.ide.runconfig;

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

/**
 * Created by sidharthkuruvila on 17/05/16.
 */
public class OcamlRunConfigurationForm extends SettingsEditor<OcamlFileRunConfiguration> {
    private TextFieldWithBrowseButton mlFilePath;
    private JPanel root;

    public OcamlRunConfigurationForm(Project project) {
        mlFilePath.addBrowseFolderListener("Something", "Something", project,
                FileChooserDescriptorFactory.createSingleFileDescriptor("ml"));
    }

    @Override
    protected void resetEditorFrom(OcamlFileRunConfiguration s) {
        mlFilePath.setText(s.getMlFilePath());
    }

    @Override
    protected void applyEditorTo(OcamlFileRunConfiguration s) throws ConfigurationException {

        s.setMlFilePath(mlFilePath.getText());
    }

    @NotNull
    @Override
    protected JComponent createEditor() {
        return root;
    }
}
