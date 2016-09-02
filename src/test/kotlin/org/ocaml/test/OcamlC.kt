package org.ocaml.test

import com.intellij.openapi.util.io.FileUtil
import java.io.File

/**
 * Created by sidharthkuruvila on 11/05/16.
 */
object OcamlC {



    fun selectOcamlC (): String {
        val l = listOf("/usr/local/bin/ocamlc")
        return l.find {fn -> File(fn).exists()} ?: "ocaml"
    }

    val ocamlc = selectOcamlC()
    /**
     * Check if file parses with ocamlc
     */
    fun parses(src: File): Boolean {

        val s: String

        val fo = createTempFile()

        try {
            val pb = ProcessBuilder(ocamlc, "-dparsetree", src.absolutePath)
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