package org.ocaml.merlin

import org.junit.Assert
import org.junit.Test
import java.io.File

class TestMerlin3 {
    val fn = "abc.ml"

    @Test
    fun testError() {
        val src = """
        let f x = print_string x
        let g x = f 1
        let _ = g "a"
        """
        val m = Merlin3.getInstance()
        val expected = listOf(MerlinError(start=Position(line=3, col=20), end=Position(line=3, col=21), valid=true,
                message="This expression has type int but an expression was expected of type string",
                type="typer", sub = emptyList()))
        val resp = m.errors(fn, src)
        Assert.assertEquals(expected, resp)
    }

    @Test
    fun testComplete() {
        val src = """
        let l1 = [1;2;3]
        let sq x = x*x
        let l2 = List.ma sq l
        let _ = print_string "hello"
        """
        val m = Merlin3.getInstance()
        val expected = Completions(
                entries=listOf(
                        CompletionEntry(name="List.mapi", kind="Value", desc="(int -> 'a -> 'b) -> 'a list -> 'b list", info="", deprecated = false),
                        CompletionEntry(name="List.map2", kind="Value", desc="('a -> 'b -> 'c) -> 'a list -> 'b list -> 'c list", info="", deprecated = false),
                        CompletionEntry(name="List.map", kind="Value", desc="('a -> 'b) -> 'a list -> 'b list", info="", deprecated = false),
                        CompletionEntry(name="ListLabels.mapi", kind="Value", desc="f:(int -> 'a -> 'b) -> 'a list -> 'b list", info="", deprecated = false),
                        CompletionEntry(name="ListLabels.map2", kind="Value", desc="f:('a -> 'b -> 'c) -> 'a list -> 'b list -> 'c list", info="", deprecated = false),
                        CompletionEntry(name="ListLabels.map", kind="Value", desc="f:('a -> 'b) -> 'a list -> 'b list", info="", deprecated = false)).reversed(),
                context=null)
        val resp = m.complete(fn,  src, "List.ma", Position(4, 25))
        Assert.assertEquals(expected.entries.toSet(), resp.entries.toSet())
    }

    @Test
    fun testLocate(){
        val src = """
        let l1 = [1;2;3]
        let sq x = x*x
        let l2 = List.map sq l
        let _ = print_string "hello"
        """

        val m = Merlin3.getInstance()

        fun testPos(pos: Position, expected: LocateResponse){
            val res = m.locate(fn, src, pos)
            if(expected is Located && res is Located){
                Assert.assertEquals(expected.file, res.file)
            } else {
                Assert.assertEquals(expected, res)
            }
        }

        val version = ocamlVersion()

        val s = "${System.getProperty("user.home")}/.opam/$version/lib/ocaml/stdlib.ml"
        testPos(Position(line=5, col = 20), Located(file=s, pos=Position(line=448, col=4)))
        testPos(Position(line=4, col = 14), LocatedAtPosition)
        testPos(Position(line=4, col = 30), LocateFailed(msg="Not in environment 'l'"))
        testPos(Position(line=4, col = 31), LocateFailed(msg="Not a valid identifier"))
        testPos(Position(line=4, col = 28), Located(file="abc.ml", pos=Position(line=3, col=8)))
    }

    private fun ocamlVersion(): String {
        val opamConfig = File("${System.getProperty("user.home")}/.opam/config").readText()
        val match = Regex("switch: \"([^\"]*)\"").find(opamConfig)
        match!!.next()
        val version = match.groupValues[1]
        return version
    }
}