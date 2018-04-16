package org.ocaml.jbuild.highlighter

import com.intellij.lexer.FlexAdapter
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType
import org.ocaml.sexp.lexer.SexpTypes
import org.ocaml.sexp.lexer._SexpLexer

class JbuilderSyntaxHighlighter : SyntaxHighlighterBase() {
    companion object {
        val ATOM = TextAttributesKey.createTextAttributesKey("OCAML_JBUILDER_ATOM", DefaultLanguageHighlighterColors.STRING)
        val COMMENT = TextAttributesKey.createTextAttributesKey("OCAML_JBUILDER_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT)
        val PAREN = TextAttributesKey.createTextAttributesKey("OCAML_JBUILDER_PAREN", DefaultLanguageHighlighterColors.PARENTHESES)
        val STANZA = TextAttributesKey.createTextAttributesKey("OCAML_JBUILDER_PAREN", DefaultLanguageHighlighterColors.KEYWORD)


        val ATOM_KEYS = arrayOf(ATOM)
        val COMMENT_KEYS = arrayOf(COMMENT)
        val PAREN_KEYS = arrayOf(PAREN)
        val EMPTY_KEYS = emptyArray<TextAttributesKey>()
    }
    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {
        return when(tokenType){
            SexpTypes.ATOM -> ATOM_KEYS
            SexpTypes.COMMENT -> COMMENT_KEYS
            SexpTypes.RPAREN, SexpTypes.LPAREN -> PAREN_KEYS
            else -> EMPTY_KEYS
        }
    }

    override fun getHighlightingLexer(): Lexer {
        return FlexAdapter(_SexpLexer(null))
    }

}