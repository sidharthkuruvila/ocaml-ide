package org.ocaml.ide.runconfig

import com.intellij.compiler.options.CompileStepBeforeRun
import com.intellij.execution.BeforeRunTask
import com.intellij.execution.configurations.ConfigurationFactory
import com.intellij.execution.configurations.ConfigurationType
import com.intellij.execution.configurations.ConfigurationTypeBase
import com.intellij.execution.configurations.RunConfiguration
import com.intellij.openapi.extensions.Extensions
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Key
import org.ocaml.lang.OcamlIcons

/**
 * Created by sidharthkuruvila on 17/05/16.
 */
class OcamlRunConfigurationType : ConfigurationTypeBase("OcamlRunFileConfiguration",
        "Ocaml",
        "Run configuration for ocaml files",
        OcamlIcons.CAMEL_ICON_FILE) {
    init {
        addFactory(object : ConfigurationFactory(this) {
            override fun createTemplateConfiguration(project: Project): RunConfiguration =
                    OcamlFileRunConfiguration("Ocaml File", project, getInstance())

            override fun configureBeforeRunTaskDefaults(providerID: Key<out BeforeRunTask<BeforeRunTask<*>>>,
                                                        task: BeforeRunTask<out BeforeRunTask<*>>) {
                if (providerID == CompileStepBeforeRun.ID) {
                    task.isEnabled = false
                }
            }
        })
    }

    companion object {
        fun getInstance(): OcamlRunConfigurationType {
            return Extensions.findExtension(ConfigurationType.CONFIGURATION_TYPE_EP, OcamlRunConfigurationType::class.java)
        }
    }
}