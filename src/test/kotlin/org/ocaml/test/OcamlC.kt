package org.ocaml.test

import com.intellij.openapi.util.io.FileUtil
import org.ocaml.merlin.OpamCommand
import java.io.File

object OcamlC {

    val opamCommand = OpamCommand()

    /**
     * Check if file parses with ocamlc
     */
    fun parses(src: File): Boolean {

        val s: String

        val fo = createTempFile()

        try {
            val pb = opamCommand.processBuilder("ocamlc", "-dparsetree", src.absolutePath)
            pb.redirectError(fo)
            val p = pb.start()
            p.waitFor()
            s = FileUtil.loadFile(fo)
        } finally {
            fo.delete()
        }
        if(s.contains("Error: Syntax error")) {
            println(s)
        }
        return !s.contains("Error: Syntax error")
    }

    fun assertParses(src: File) {
        org.junit.Assert.assertTrue("Ocaml failed to parse file ${src.absoluteFile}", parses(src))
    }
}