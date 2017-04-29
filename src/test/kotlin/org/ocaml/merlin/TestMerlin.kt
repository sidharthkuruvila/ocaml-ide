package org.ocaml.merlin

import org.junit.Assert.assertEquals
import org.junit.Test
import java.io.File

/**
 * Created by sidharthkuruvila on 01/05/16.
 */


class TestMerlin {

    val fn = "abc.ml"
    @Test
    fun testTellSource() {
        val m = merlinInstance()
        m.tellSource(fn, "let f x = x;; `")
        val resp2 = m.tellSource(fn, "let f x = x;;")
        assertEquals(true, resp2)
    }


    @Test
    fun testError() {
        val src = """
        let f x = print_string x
        let g x = f 1
        let _ = g "a"
        """
        val m = merlinInstance()
        m.tellSource(fn, src)
        val expected = listOf(MerlinError(start=Position(line=3, col=20), end=Position(line=3, col=21), valid=true,
                message="This expression has type int but an expression was expected of type\n         string",
                type="type", sub = emptyList()))
        val resp = m.errors(fn)
        assertEquals(expected, resp)

    }

    @Test
    fun testComplete() {
        val src = """
        let l1 = [1;2;3]
        let sq x = x*x
        let l2 = List.ma sq l
        let _ = print_string "hello"
        """
        val m = merlinInstance()
        m.tellSource(fn, src)
        val expected = Completions(
                entries=listOf(
                        CompletionEntry(name="List.mapi", kind="Value", desc="(int -> 'a -> 'b) -> 'a list -> 'b list", info=""),
                        CompletionEntry(name="List.map2", kind="Value", desc="('a -> 'b -> 'c) -> 'a list -> 'b list -> 'c list", info=""),
                        CompletionEntry(name="List.map", kind="Value", desc="('a -> 'b) -> 'a list -> 'b list", info=""),
                        CompletionEntry(name="ListLabels.mapi", kind="Value", desc="f:(int -> 'a -> 'b) -> 'a list -> 'b list", info=""),
                        CompletionEntry(name="ListLabels.map2", kind="Value", desc="f:('a -> 'b -> 'c) -> 'a list -> 'b list -> 'c list", info=""),
                        CompletionEntry(name="ListLabels.map", kind="Value", desc="f:('a -> 'b) -> 'a list -> 'b list", info="")).reversed(),
                context=null)
        val resp = m.complete(fn, "List.ma", Position(4, 21))
        assertEquals(expected.entries.toSet(), resp.entries.toSet())
        assertEquals(expected.context, resp.context)

    }

    @Test
    fun testDumpTokens() {
        val m = merlinInstance()
        m.tellSource(fn, "let f x = x;;")
        val exp = listOf(Token(start = Position(line = 1, col = 0), end = Position(line = 1, col = 3), token = "let"),
                Token(start = Position(line = 1, col = 4), end = Position(line = 1, col = 5), token = "LIDENT(\"f\")"),
                Token(start = Position(line = 1, col = 6), end = Position(line = 1, col = 7), token = "LIDENT(\"x\")"),
                Token(start = Position(line = 1, col = 8), end = Position(line = 1, col = 9), token = "="),
                Token(start = Position(line = 1, col = 10), end = Position(line = 1, col = 11), token = "LIDENT(\"x\")"),
                Token(start = Position(line = 1, col = 11), end = Position(line = 1, col = 13), token = ";;"),
                Token(start=Position(line=1, col=13), end=Position(line=1, col=13), token="EOF"))
        val resp = m.dumpTokens(fn)
        assertEquals(exp, resp)
    }

    @Test
    fun testDumpBrowse1() {
        val m = merlinInstance()
        m.tellSource(fn, """#!/var/bin
            open Mood
                let f x = x let x = 2""")
        m.dumpBrowse2(fn)
    }

    //@Test
    //@Ignore
    fun xtestDumpBrowse() {
        val m = merlinInstance()
        m.tellSource(fn, "let f x = x;;")
        val resp = m.dumpBrowse(fn)

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


    @Test
    fun testLocate(){
        val src = """
        let l1 = [1;2;3]
        let sq x = x*x
        let l2 = List.map sq l
        let _ = print_string "hello"
        """

        val m = merlinInstance()

        m.tellSource(fn, src)

        fun testPos(pos: Position, expected: LocateResponse){
            val res = m.locate(fn, pos)
            assertEquals(expected, res)
        }

        val version = ocamlVersion()

        val s = "${System.getProperty("user.home")}/.opam/$version/lib/ocaml/pervasives.ml"
        testPos(Position(line=5, col = 20), Located(file=s, pos=Position(line=448, col=4)))
        testPos(Position(line=4, col = 14), LocatedAtPosition)
        testPos(Position(line=4, col = 30), LocateFailed(msg="Not in environment 'l'"))
        testPos(Position(line=4, col = 31), LocateFailed(msg="Not a valid identifier"))
        testPos(Position(line=4, col = 28), LocateFailed(msg="'sq' seems to originate from 'Abc' whose ML file could not be found"))
    }

    private fun ocamlVersion(): String {
        val opamConfig = File("${System.getProperty("user.home")}/.opam/config").readText()
        val match = Regex("switch: \"([^\"]*)\"").find(opamConfig)
        match!!.next()
        val version = match.groupValues[1]
        return version
    }

    private fun merlinInstance(): Merlin {
        return Merlin.newInstance()
    }


}