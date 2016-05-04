package org.ocaml.lang.lexer

import com.intellij.lang.Language
import com.intellij.psi.tree.IElementType
import org.ocaml.lang.OcamlLanguage

/**
 * Created by sidharthkuruvila on 02/05/16.
 */

//class SimpleTypes(name: String): IElementType(name, Language.ANY) {
//
//}

object OcamlTypes {

    @JvmField
    val AMPERAMPER = IElementType("AMPERAMPER", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val AMPERSAND = IElementType("AMPERSAND", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val AND = IElementType("AND", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val AS = IElementType("AS", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val ASSERT = IElementType("ASSERT", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val BACKQUOTE = IElementType("BACKQUOTE", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val BANG = IElementType("BANG", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val BAR = IElementType("BAR", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val BARBAR = IElementType("BARBAR", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val BARRBRACKET = IElementType("BARRBRACKET", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val BEGIN = IElementType("BEGIN", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val CHAR = IElementType("CHAR", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val CLASS = IElementType("CLASS", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val COLON = IElementType("COLON", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val COLONCOLON = IElementType("COLONCOLON", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val COLONEQUAL = IElementType("COLONEQUAL", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val COLONGREATER = IElementType("COLONGREATER", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val COMMA = IElementType("COMMA", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val CONSTRAINT = IElementType("CONSTRAINT", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val DO = IElementType("DO", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val DONE = IElementType("DONE", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val DOT = IElementType("DOT", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val DOTDOT = IElementType("DOTDOT", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val DOWNTO = IElementType("DOWNTO", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val ELSE = IElementType("ELSE", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val END = IElementType("END", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val EOF = IElementType("EOF", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val EQUAL = IElementType("EQUAL", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val EXCEPTION = IElementType("EXCEPTION", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val EXTERNAL = IElementType("EXTERNAL", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val FALSE = IElementType("FALSE", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val FLOAT = IElementType("FLOAT", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val FOR = IElementType("FOR", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val FUN = IElementType("FUN", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val FUNCTION = IElementType("FUNCTION", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val FUNCTOR = IElementType("FUNCTOR", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val GREATER = IElementType("GREATER", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val GREATERRBRACE = IElementType("GREATERRBRACE", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val GREATERRBRACKET = IElementType("GREATERRBRACKET", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val IF = IElementType("IF", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val IN = IElementType("IN", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val INCLUDE = IElementType("INCLUDE", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val INFIXOP0 = IElementType("INFIXOP0", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val INFIXOP1 = IElementType("INFIXOP1", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val INFIXOP2 = IElementType("INFIXOP2", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val INFIXOP3 = IElementType("INFIXOP3", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val INFIXOP4 = IElementType("INFIXOP4", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val INHERIT = IElementType("INHERIT", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val INITIALIZER = IElementType("INITIALIZER", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val INT = IElementType("INT", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val INT32 = IElementType("INT32", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val INT64 = IElementType("INT64", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val LABEL = IElementType("LABEL", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val LAZY = IElementType("LAZY", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val LBRACE = IElementType("LBRACE", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val LBRACELESS = IElementType("LBRACELESS", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val LBRACKET = IElementType("LBRACKET", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val LBRACKETBAR = IElementType("LBRACKETBAR", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val LBRACKETLESS = IElementType("LBRACKETLESS", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val LBRACKETGREATER = IElementType("LBRACKETGREATER", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val LBRACKETPERCENT = IElementType("LBRACKETPERCENT", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val LBRACKETPERCENTPERCENT = IElementType("LBRACKETPERCENTPERCENT", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val LESS = IElementType("LESS", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val LESSMINUS = IElementType("LESSMINUS", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val LET = IElementType("LET", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val LIDENT = IElementType("LIDENT", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val LPAREN = IElementType("LPAREN", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val LBRACKETAT = IElementType("LBRACKETAT", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val LBRACKETATAT = IElementType("LBRACKETATAT", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val LBRACKETATATAT = IElementType("LBRACKETATATAT", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val MATCH = IElementType("MATCH", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val METHOD = IElementType("METHOD", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val MINUS = IElementType("MINUS", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val MINUSDOT = IElementType("MINUSDOT", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val MINUSGREATER = IElementType("MINUSGREATER", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val MODULE = IElementType("MODULE", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val MUTABLE = IElementType("MUTABLE", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val NATIVEINT = IElementType("NATIVEINT", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val NEW = IElementType("NEW", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val NONREC = IElementType("NONREC", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val OBJECT = IElementType("OBJECT", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val OF = IElementType("OF", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val OPEN = IElementType("OPEN", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val OPTLABEL = IElementType("OPTLABEL", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val OR = IElementType("OR", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val PERCENT = IElementType("PERCENT", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val PLUS = IElementType("PLUS", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val PLUSDOT = IElementType("PLUSDOT", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val PLUSEQ = IElementType("PLUSEQ", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val PREFIXOP = IElementType("PREFIXOP", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val PRIVATE = IElementType("PRIVATE", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val QUESTION = IElementType("QUESTION", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val QUOTE = IElementType("QUOTE", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val RBRACE = IElementType("RBRACE", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val RBRACKET = IElementType("RBRACKET", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val REC = IElementType("REC", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val RPAREN = IElementType("RPAREN", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val SEMI = IElementType("SEMI", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val SEMISEMI = IElementType("SEMISEMI", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val SHARP = IElementType("SHARP", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val SHARPOP = IElementType("SHARPOP", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val SIG = IElementType("SIG", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val STAR = IElementType("STAR", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val STRING = IElementType("STRING", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val STRUCT = IElementType("STRUCT", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val THEN = IElementType("THEN", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val TILDE = IElementType("TILDE", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val TO = IElementType("TO", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val TRUE = IElementType("TRUE", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val TRY = IElementType("TRY", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val TYPE = IElementType("TYPE", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val UIDENT = IElementType("UIDENT", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val UNDERSCORE = IElementType("UNDERSCORE", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val VAL = IElementType("VAL", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val VIRTUAL = IElementType("VIRTUAL", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val WHEN = IElementType("WHEN", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val WHILE = IElementType("WHILE", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val WITH = IElementType("WITH", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val COMMENT = IElementType("COMMENT", OcamlLanguage.Companion.INSTANCE)
    @JvmField
    val DOCSTRING = IElementType("DOCSTRING", OcamlLanguage.Companion.INSTANCE)


}