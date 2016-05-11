package org.ocaml.lang.parser

import com.intellij.openapi.util.io.FileUtil
import com.intellij.testFramework.ParsingTestCase
import org.ocaml.merlin.BrowseNode
import org.ocaml.merlin.Merlin
import org.ocaml.test.OcamlC
import java.io.File

/**
 * Created by sidharthkuruvila on 08/05/16.
 */
class OcamlParserTest : ParsingTestCase("org/ocaml/lang/parser", "ml", OcamlParserDefinition()) {

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
        return "src/test/resources";
    }

    fun getTestFile(): File {
        val fn = testName + "." + myFileExt
        return File(myFullDataPath, fn)
    }
}