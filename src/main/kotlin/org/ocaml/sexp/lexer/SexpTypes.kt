package org.ocaml.sexp.lexer

import org.ocaml.lang.lexer.OcamlTokenElementType

object SexpTypes {

    @JvmField
    val ATOM = SexpTokenElementType("ATOM")
    @JvmField
    val COMMENT = SexpTokenElementType("COMMENT")

    @JvmField
    val LPAREN = SexpTokenElementType("LPAREN")

    @JvmField
    val RPAREN = SexpTokenElementType("RPAREN")


}