package org.ocaml.util

class ReversedSubstringCharSequence(private val string: String,private val start: Int, private val end: Int): CharSequence {

    init {
        assert(end in 0..start && start < string.length)
    }
    override fun get(index: Int): Char {
        return string[start - index]
    }

    override fun subSequence(startIndex: Int, endIndex: Int): CharSequence {
        return ReversedSubstringCharSequence(string, end + endIndex - 1, end + startIndex)
    }

    override val length = start - end + 1

    override fun toString(): String { return StringBuilder(this).toString() }
}