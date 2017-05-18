package org.ocaml.ide.completion

import com.intellij.codeInsight.completion.CompletionType
import com.intellij.testFramework.UsefulTestCase
import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixtureTestCase


class OcamlCompletionContributorTest : LightPlatformCodeInsightFixtureTestCase() {

    fun testAutoComplete(){
        val script = """
        module TestModule = struct
            let some_val = 1
            let some_other_val = 2
        end
        let a = TestModule.some_<caret>"""
        val expected =  arrayOf("TestModule.some_other_val", "TestModule.some_val")
        myFixture.configureByText("test.ml", script)
        val res = this.myFixture.complete(CompletionType.BASIC).map { it.lookupString }.toTypedArray()
        UsefulTestCase.assertOrderedEquals(expected, *res)
    }
}