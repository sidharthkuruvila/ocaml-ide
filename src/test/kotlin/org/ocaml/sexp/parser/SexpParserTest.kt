package org.ocaml.sexp.parser

import com.intellij.testFramework.ParsingTestCase
import org.ocaml.test.OcamlC
import java.io.File

class SexpParserTest : ParsingTestCase("org/ocaml/sexp/parser", "sexp", SexpParserDefinition()) {

    fun testSimpleExpressions() {
        try {
            OcamlC.assertParses(getTestFile())
        } catch (e: java.lang.AssertionError) {
            e.printStackTrace()
        }
        doTest(true)
        OcamlC.assertParses(getTestFile())


    }

    override fun getTestDataPath(): String {
        return "src/test/resources"
    }

    fun getTestFile(): File {
        val fn = testName + "." + myFileExt
        return File(myFullDataPath, fn)
    }
}