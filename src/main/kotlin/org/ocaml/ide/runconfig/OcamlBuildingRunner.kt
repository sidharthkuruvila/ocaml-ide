package org.ocaml.ide.runconfig

import com.intellij.execution.configurations.RunProfile
import com.intellij.execution.executors.DefaultRunExecutor
import com.intellij.execution.runners.DefaultProgramRunner
import com.intellij.execution.runners.RunConfigurationWithSuppressedDefaultRunAction
import com.intellij.openapi.diagnostic.Logger

/**
 * Created by sidharthkuruvila on 18/05/16.
 */
class OcamlBuildingRunner : DefaultProgramRunner(), RunConfigurationWithSuppressedDefaultRunAction {
    companion object {
        private val LOG = Logger.getInstance(OcamlBuildingRunner::class.java)
        val ID = "OcamlBuildingRunner"
    }
    override fun canRun(executorId: String, profile: RunProfile): Boolean {
        LOG.info("Checking if ocaml building runner can run for ${OcamlFileRunConfiguration::class.toString()} and matches executor : ${DefaultRunExecutor.EXECUTOR_ID == executorId} returns ${DefaultRunExecutor.EXECUTOR_ID == executorId && profile is OcamlFileRunConfiguration}")
        if(DefaultRunExecutor.EXECUTOR_ID == executorId && profile is OcamlFileRunConfiguration){
            LOG.info("looking good")
        }
        return DefaultRunExecutor.EXECUTOR_ID == executorId && profile is OcamlFileRunConfiguration;
    }

    override fun getRunnerId(): String = ID
}