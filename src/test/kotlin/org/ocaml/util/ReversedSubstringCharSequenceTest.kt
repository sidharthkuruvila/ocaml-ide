package org.ocaml.util

import org.junit.Assert
import org.junit.Test


class ReversedSubstringCharSequenceTest {

    @Test
    fun shouldContainCharactersInReversedOrder(){
        val s = "This is a string"
        val r= ReversedSubstringCharSequence(s, 10, 0).toString()
        val e = "s a si sihT"
        Assert.assertEquals(e, r)
    }

    @Test
    fun subSequenceShouldHaveCorrectCharacters() {
        val s = "This is a string"
        val r= ReversedSubstringCharSequence(s, 10, 0).subSequence(0, 5).toString()
        println(r)
        val e = " sihT"
        Assert.assertEquals(e, r)
    }

}
