package org.ocaml.lang.parser

import com.intellij.lang.*
import com.intellij.openapi.project.Project
import com.intellij.openapi.util.Key
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import com.intellij.testFramework.ParsingTestCase
import com.intellij.util.diff.FlyweightCapableTreeStructure
import org.junit.Test

import org.junit.Assert.*
import org.junit.Ignore
import org.ocaml.merlin.Merlin
import org.ocaml.merlin.MerlinLexer

/**
 * Created by sidharthkuruvila on 08/05/16.
 */
class MerlinParserTest : ParsingTestCase("org/ocaml/lang/parser", "ml", OcamlParserDefinition()) {
    @Test
    @Ignore
    fun testParsingTestData() {
        //doTest(true);
    }

    override fun getTestDataPath(): String {
        return "src/test/resources";
    }
}