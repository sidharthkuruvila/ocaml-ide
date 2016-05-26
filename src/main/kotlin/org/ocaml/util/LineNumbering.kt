package org.ocaml.util

import org.ocaml.merlin.Position

/**
 * Created by sidharthkuruvila on 25/05/16.
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
        lineIndex.add(i)
    }

    fun index(position: Position): Int {
        return lineIndex[position.line - 1] + position.col
    }

    fun position(index: Int): Position {
        var i = 0
        while (lineIndex[i] <= index) {
            i++
        }
        i--
        return Position(line = i + 1, col = index - lineIndex[i])
    }
}