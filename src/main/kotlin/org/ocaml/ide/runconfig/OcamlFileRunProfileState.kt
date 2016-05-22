package org.ocaml.ide.runconfig

import com.intellij.execution.configurations.CommandLineState
import com.intellij.execution.configurations.GeneralCommandLine
import com.intellij.execution.process.OSProcessHandler
import com.intellij.execution.process.ProcessHandler
import com.intellij.execution.runners.ExecutionEnvironment
import java.io.File

/**
 * Created by sidharthkuruvila on 17/05/16.
 */

class OcamlFileRunProfileState(environment: ExecutionEnvironment) : CommandLineState(environment) {
    lateinit var filename: String
    override fun startProcess(): ProcessHandler {

        val fn = filename

        val commandLine = GeneralCommandLine("bash", "-c", buildAndRunCmd(environment, fn))
        commandLine.workDirectory = File(environment.project.baseDir.path)
        val oph = OSProcessHandler(commandLine)
        return oph
    }

    fun buildAndRunCmd(environment: ExecutionEnvironment, filepath: String) : String {
        val basePath = environment.project.baseDir

        val relFilname = File(filepath).toRelativeString(File(basePath.path))

        if(!filepath.endsWith(".ml")) {
            throw IllegalStateException("Can only run ml files")
        }

        val outputFile = relFilname.toString().replace(".ml", ".native")
        val s = "pwd && ocamlbuild $outputFile && ./$outputFile"
        return s
    }

}