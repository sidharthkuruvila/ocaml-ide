package org.ocaml.lang.parser

import com.intellij.testFramework.ParsingTestCase

/**
 * Created by sidharthkuruvila on 08/05/16.
 */
class OcamlParserTest : ParsingTestCase("org/ocaml/lang/parser", "ml", OcamlParserDefinition()) {

    fun testSimpleExpressions() {
        doTest(true);
    }

    override fun getTestDataPath(): String {
        return "src/test/resources";
    }
}