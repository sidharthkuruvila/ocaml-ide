package org.ocaml.jbuild.parser

import com.intellij.testFramework.ParsingTestCase
import java.io.File

class JbuildParserTest : ParsingTestCase("org/ocaml/jbuild/parser", "jbuild", JbuilderParserDefinition()) {

    fun testSimpleExpressions() {
        doTest(true)
    }

    override fun getTestDataPath(): String {
        return "src/test/resources"
    }

    fun getTestFile(): File {
        val fn = testName + "." + myFileExt
        return File(myFullDataPath, fn)
    }
}