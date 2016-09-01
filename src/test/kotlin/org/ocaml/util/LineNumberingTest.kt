package org.ocaml.util

import org.junit.Assert.assertEquals
import org.junit.Test
import org.ocaml.merlin.Position

class LineNumberingTest {
    val src = """

abc
def
"""
    val positions = listOf(Position(line = 1, col = 0), Position(line = 2, col = 0), Position(line = 3, col = 0),
            Position(line = 3, col = 1), Position(line = 3, col = 2), Position(line = 3, col = 3), Position(line = 4, col = 0),
            Position(line = 4, col = 1), Position(line = 4, col = 2), Position(line = 4, col = 3))
    val indexes = (0..src.length - 1).toList()
    @Test
    fun testGetPosition() {
        val ln = LineNumbering(src)
        val resp = indexes.map { ln.position(it) }
        val expected = positions
        assertEquals(expected, resp)
    }

    @Test
    fun testGetIndex() {
        val ln = LineNumbering(src)
        val resp = positions.map { ln.index(it)}
        val expected = indexes
        assertEquals(expected, resp)
    }

    @Test
    fun testGetLastIndex() {
        val src = "let a = b"
        val ln = LineNumbering(src)
        val resp = ln.position(9)
        println(resp)
    }
}