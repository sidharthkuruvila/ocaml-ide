package kuruvila.ocamlidea

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase

import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import kuruvila.merlin.Merlin
import kuruvila.merlin.MerlinLexer
import kuruvila.ocamlidea.lexer.OcamlTypes

/**
 * Created by sidharthkuruvila on 02/05/16.
 */

class OcamlSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return MerlinLexer(Merlin.newInstance())
    }

    override fun getTokenHighlights(tokenType: IElementType?): Array<out TextAttributesKey> {
        when (tokenType) {
            OcamlTypes.IDENTIFIER -> return IDENTIFIER_KEYS
            OcamlTypes.COMMENT -> return COMMENT_KEYS
            OcamlTypes.STRING -> return STRING_KEYS
            OcamlTypes.KEYWORD -> return KEYWORD_KEYS
            TokenType.BAD_CHARACTER -> return BAD_CHAR_KEYS
            else -> return EMPTY_KEYS
        }
    }

    val IDENTIFIER =
            createTextAttributesKey("OCAML_IDENTIFIER", DefaultLanguageHighlighterColors.IDENTIFIER);
    val KEYWORD =
            createTextAttributesKey("OCAML_KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    val STRING =
            createTextAttributesKey("OCAML_STRING", DefaultLanguageHighlighterColors.STRING);
    val COMMENT =
            createTextAttributesKey("OCAML_COMMENT", DefaultLanguageHighlighterColors.BLOCK_COMMENT);
    val BAD_CHARACTER =
            createTextAttributesKey("SIMPLE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER);
    val IDENTIFIER_KEYS = arrayOf(IDENTIFIER);
    val KEYWORD_KEYS = arrayOf(KEYWORD);
    val STRING_KEYS = arrayOf(STRING);
    val COMMENT_KEYS = arrayOf(COMMENT);
    val EMPTY_KEYS = emptyArray<TextAttributesKey>();




}