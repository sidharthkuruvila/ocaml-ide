package org.ocaml.merlin

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.junit.Assert.assertEquals
import org.junit.Ignore
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

    @Test
    fun testDumpBrowse1() {
        val m = merlinInstance()
        m.tellSource("""#!/var/bin
            open Mood
                let f x = x let x = 2""")
        val resp = m.dumpBrowse2()
        println(resp)
    }

    //@Test
    //@Ignore
    fun xtestDumpBrowse() {
        val m = merlinInstance()
        m.tellSource("let f x = x;;")
        val resp = m.dumpBrowse()

        val exp = listOf(
                BrowseNode(
                        start = Position(line = 1, col = 0),
                        end = Position(line = 1, col = 11),
                        ghost = false,
                        attrs = emptyList(),
                        kind = "structure",
                        children = listOf(
                                BrowseNode(
                                        start = Position(line = 1, col = 0),
                                        end = Position(line = 1, col = 11),
                                        ghost = false,
                                        attrs = emptyList(),
                                        kind = "structure_item",
                                        children = listOf(
                                                BrowseNode(start = Position(line = 1, col = 4),
                                                        end = Position(line = 1, col = 11),
                                                        ghost = false, attrs = emptyList(),
                                                        kind = "value_binding",
                                                        children = listOf(
                                                                BrowseNode(
                                                                        start = Position(line = 1, col = 4),
                                                                        end = Position(line = 1, col = 5),
                                                                        ghost = false, attrs = emptyList(),
                                                                        kind = "pattern (*buffer*[1,0+4]..*buffer*[1,0+5])\n  Ppat_var \"f/1011\"\n",
                                                                        children = emptyList()),
                                                                BrowseNode(
                                                                        start = Position(line = 1, col = 6),
                                                                        end = Position(line = 1, col = 11),
                                                                        ghost = true, attrs = emptyList(),
                                                                        kind = "expression",
                                                                        children = listOf(
                                                                                BrowseNode(
                                                                                        start = Position(line = 1, col = 6),
                                                                                        end = Position(line = 1, col = 11),
                                                                                        ghost = false, attrs = emptyList(),
                                                                                        kind = "case",
                                                                                        children = listOf(
                                                                                                BrowseNode(
                                                                                                        start = Position(line = 1, col = 6),
                                                                                                        end = Position(line = 1, col = 7),
                                                                                                        ghost = false,
                                                                                                        attrs = emptyList(),
                                                                                                        kind = "pattern (*buffer*[1,0+6]..*buffer*[1,0+7])\n  Ppat_var \"x/1012\"\n",
                                                                                                        children = emptyList()),
                                                                                                BrowseNode(
                                                                                                        start = Position(line = 1, col = 10),
                                                                                                        end = Position(line = 1, col = 11),
                                                                                                        ghost = false,
                                                                                                        attrs = emptyList(),
                                                                                                        kind = "expression",
                                                                                                        children = emptyList()))))))))))))


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
        val pb = ProcessBuilder("ocamlmerlin")
        return pb.start()
    }
}