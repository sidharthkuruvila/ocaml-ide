package kuruvila.merlin

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by sidharthkuruvila on 01/05/16.
 */


class TestMerlin {


    @Test
    fun testTellSource() {
        val m = merlinInstance()
        val resp1 = m.tellSource("let f x = x;;")
        m.seekExact(Position(1, 0))
        m.drop()
        val resp2 = m.tellSource("let f x = x;;")
        assertEquals(TellResponse(cursor = Position(line = 1, col = 13), marker = false), resp2)
    }

    @Test
    fun testDumpTokens() {
        val m = merlinInstance()
        m.tellSource("let f x = x;;")
        val exp = listOf(Token(start = Position(line = 1, col = 0), end = Position(line = 1, col = 3), token = "LET"),
                Token(start = Position(line = 1, col = 4), end = Position(line = 1, col = 5), token = "LIDENT"),
                Token(start = Position(line = 1, col = 6), end = Position(line = 1, col = 7), token = "LIDENT"),
                Token(start = Position(line = 1, col = 8), end = Position(line = 1, col = 9), token = "EQUAL"),
                Token(start = Position(line = 1, col = 10), end = Position(line = 1, col = 11), token = "LIDENT"),
                Token(start = Position(line = 1, col = 11), end = Position(line = 1, col = 13), token = "SEMISEMI"))
        val resp = m.dumpTokens()
        assertEquals(exp, resp)
    }

    private fun merlinInstance(): Merlin {
        val p = merlinProcess()
        val om = ObjectMapper()
        om.registerModule(KotlinModule())
        val m = Merlin(om, p)
        return m
    }

    private fun merlinProcess(): Process {
        val pb = ProcessBuilder("/Users/sidharthkuruvila/Code/ocaml_idea_plugin/merlin/ocamlmerlin")
        return pb.start()
    }
}