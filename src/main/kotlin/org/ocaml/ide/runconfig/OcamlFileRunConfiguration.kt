package org.ocaml.ide.runconfig

import com.intellij.execution.Executor
import com.intellij.execution.configurations.ModuleBasedConfiguration
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.execution.configurations.RunConfigurationModule
import com.intellij.execution.configurations.RunProfileState
import com.intellij.execution.runners.ExecutionEnvironment
import com.intellij.execution.runners.RunConfigurationWithSuppressedDefaultRunAction
import com.intellij.openapi.module.Module
import com.intellij.openapi.module.ModuleManager
import com.intellij.openapi.options.SettingsEditor
import com.intellij.openapi.project.Project
import org.ocaml.ide.runconfig.form.OcamlRunConfigurationForm


/**
 * Created by sidharthkuruvila on 17/05/16.
 */
class OcamlFileRunConfiguration(name: String,
                                project: Project,
                                ocamlRunConfigurationType: OcamlRunConfigurationType) :
        ModuleBasedConfiguration<RunConfigurationModule>(name,
                RunConfigurationModule(project),
                ocamlRunConfigurationType.configurationFactories[0]), RunConfigurationWithSuppressedDefaultRunAction {

    var mlFilePath: String = project.basePath!!

    override fun getConfigurationEditor(): SettingsEditor<out RunConfiguration> {

        val ocamlRunConfigurationForm = OcamlRunConfigurationForm(project)
        return  ocamlRunConfigurationForm
    }

    override fun getValidModules(): Collection<Module>? {
        return ModuleManager.getInstance(project).modules.toList()
    }

    override fun getState(executor: Executor, environment: ExecutionEnvironment): RunProfileState? {
        val ocamlScriptRunProfileState = OcamlFileRunProfileState(environment)
        ocamlScriptRunProfileState.filename = mlFilePath
        return ocamlScriptRunProfileState
    }
}