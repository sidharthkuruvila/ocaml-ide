package org.ocaml

import com.intellij.testFramework.fixtures.LightPlatformCodeInsightFixtureTestCase
import junit.framework.Assert

class IdeSanityTest  : LightPlatformCodeInsightFixtureTestCase() {
    fun testOcaml(){
        val script = """
        module TestModule = struct
            let some_val = 1
            let some_other_val = 2
        end"""
        myFixture.configureByText("test.ml", script)

        val lang = myFixture.file.language.id
        Assert.assertEquals("Ocaml", lang)
    }

    fun testJBuild(){
        val script = "((jbuild_version 1))"
        myFixture.configureByText("jbuild", script)
        val lang = myFixture.file.language.id
        Assert.assertEquals("OcamlJbuilder", lang)
    }

}