package org.ocaml.sexp.lexer

import org.ocaml.lang.lexer.OcamlTokenElementType

object SexpTypes {

    @JvmField
    val ATOM = OcamlTokenElementType("ATOM")
    @JvmField
    val COMMENT = OcamlTokenElementType("COMMENT")

    @JvmField
    val LPAREN = OcamlTokenElementType("LPAREN")

    @JvmField
    val RPAREN = OcamlTokenElementType("RPAREN")


}