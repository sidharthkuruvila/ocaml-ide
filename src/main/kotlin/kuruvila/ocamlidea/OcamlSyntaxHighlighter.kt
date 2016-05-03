package kuruvila.ocamlidea

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase

import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import kuruvila.ocamlidea.lexer.OcamlLexer
import kuruvila.ocamlidea.lexer.OcamlTypes

/**
 * Created by sidharthkuruvila on 02/05/16.
 */

class OcamlSyntaxHighlighter : SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return OcamlLexer()
    }

    override fun getTokenHighlights(tokenType: IElementType?): Array<out TextAttributesKey> {
        when (tokenType) {
            OcamlTypes.SEPARATOR -> return SEPARATOR_KEYS
            OcamlTypes.COMMENT -> return COMMENT_KEYS
            OcamlTypes.VALUE -> return VALUE_KEYS
            OcamlTypes.KEY -> return KEY_KEYS
            TokenType.BAD_CHARACTER -> return BAD_CHAR_KEYS
            else -> return EMPTY_KEYS
        }
    }

    val SEPARATOR =
            createTextAttributesKey("SIMPLE_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN);
    val KEY =
            createTextAttributesKey("SIMPLE_KEY", DefaultLanguageHighlighterColors.KEYWORD);
    val VALUE =
            createTextAttributesKey("SIMPLE_VALUE", DefaultLanguageHighlighterColors.STRING);
    val COMMENT =
            createTextAttributesKey("SIMPLE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    val BAD_CHARACTER =
            createTextAttributesKey("SIMPLE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    val BAD_CHAR_KEYS = arrayOf(BAD_CHARACTER);
    val SEPARATOR_KEYS = arrayOf(SEPARATOR);
    val KEY_KEYS = arrayOf(KEY);
    val VALUE_KEYS = arrayOf(VALUE);
    val COMMENT_KEYS = arrayOf(COMMENT);
    val EMPTY_KEYS = emptyArray<TextAttributesKey>();




}