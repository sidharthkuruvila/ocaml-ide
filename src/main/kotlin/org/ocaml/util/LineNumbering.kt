package org.ocaml.util

import org.ocaml.merlin.Position

/**
 * Map line, column number of a character in a string
 * to it's index.
 *
 * The line number starts at one for the first line and the
 * column number starts at 0.
 *
 * For example the Position(line=3, col=2) refers to the
 * the third character in the 3rd line in a string.
 *
 */
class LineNumbering(source: CharSequence) {
    var lineIndex: MutableList<Int> = mutableListOf(0)

    init {
        var i = 0
        while (i < source.length) {
            if (source[i] == '\n') {
                lineIndex.add(i + 1)
            }
            i++
        }
        lineIndex.add(Int.MAX_VALUE)
    }

    fun index(position: Position): Int {
        return lineIndex[position.line - 1] + position.col
    }

    fun position(index: Int): Position {

        fun between(start: Int, end: Int): Boolean {
            return lineIndex[start] <= index && lineIndex[end] > index
        }

        tailrec fun bisect(start: Int, end: Int): Position {
            if(end - start == 1) {
                return Position(line = start + 1, col = index - lineIndex[start])
            }

            val mid = (start + end) / 2

            if(between(start, mid))
                return bisect(start, mid)
            else
                return bisect(mid, end)
        }

        return bisect(0, lineIndex.size - 1)
    }


}