package org.ocaml.lang.lexer

import com.intellij.lang.Language
import org.ocaml.lang.OcamlLanguage

/**
 * Created by sidharthkuruvila on 02/05/16.
 */

object OcamlTypes {

    @JvmField
    val AMPERAMPER = OcamlTokenElementType("AMPERAMPER")
    @JvmField
    val AMPERSAND = OcamlTokenElementType("AMPERSAND")
    @JvmField
    val AND = OcamlTokenElementType("AND")
    @JvmField
    val AS = OcamlTokenElementType("AS")
    @JvmField
    val ASSERT = OcamlTokenElementType("ASSERT")
    @JvmField
    val BACKQUOTE = OcamlTokenElementType("BACKQUOTE")
    @JvmField
    val BANG = OcamlTokenElementType("BANG")
    @JvmField
    val BAR = OcamlTokenElementType("BAR")
    @JvmField
    val BARBAR = OcamlTokenElementType("BARBAR")
    @JvmField
    val BARRBRACKET = OcamlTokenElementType("BARRBRACKET")
    @JvmField
    val BEGIN = OcamlTokenElementType("BEGIN")
    @JvmField
    val CHAR = OcamlTokenElementType("CHAR")
    @JvmField
    val CLASS = OcamlTokenElementType("CLASS")
    @JvmField
    val COLON = OcamlTokenElementType("COLON")
    @JvmField
    val COLONCOLON = OcamlTokenElementType("COLONCOLON")
    @JvmField
    val COLONEQUAL = OcamlTokenElementType("COLONEQUAL")
    @JvmField
    val COLONGREATER = OcamlTokenElementType("COLONGREATER")
    @JvmField
    val COMMA = OcamlTokenElementType("COMMA")
    @JvmField
    val CONSTRAINT = OcamlTokenElementType("CONSTRAINT")
    @JvmField
    val DO = OcamlTokenElementType("DO")
    @JvmField
    val DONE = OcamlTokenElementType("DONE")
    @JvmField
    val DOT = OcamlTokenElementType("DOT")
    @JvmField
    val DOTDOT = OcamlTokenElementType("DOTDOT")
    @JvmField
    val DOWNTO = OcamlTokenElementType("DOWNTO")
    @JvmField
    val ELSE = OcamlTokenElementType("ELSE")
    @JvmField
    val END = OcamlTokenElementType("END")
    @JvmField
    val EOF = OcamlTokenElementType("EOF")
    @JvmField
    val EQUAL = OcamlTokenElementType("EQUAL")
    @JvmField
    val EXCEPTION = OcamlTokenElementType("EXCEPTION")
    @JvmField
    val EXTERNAL = OcamlTokenElementType("EXTERNAL")
    @JvmField
    val FALSE = OcamlTokenElementType("FALSE")
    @JvmField
    val FLOAT = OcamlTokenElementType("FLOAT")
    @JvmField
    val FOR = OcamlTokenElementType("FOR")
    @JvmField
    val FUN = OcamlTokenElementType("FUN")
    @JvmField
    val FUNCTION = OcamlTokenElementType("FUNCTION")
    @JvmField
    val FUNCTOR = OcamlTokenElementType("FUNCTOR")
    @JvmField
    val GREATER = OcamlTokenElementType("GREATER")
    @JvmField
    val GREATERRBRACE = OcamlTokenElementType("GREATERRBRACE")
    @JvmField
    val GREATERRBRACKET = OcamlTokenElementType("GREATERRBRACKET")
    @JvmField
    val IF = OcamlTokenElementType("IF")
    @JvmField
    val IN = OcamlTokenElementType("IN")
    @JvmField
    val INCLUDE = OcamlTokenElementType("INCLUDE")
    @JvmField
    val INFIXOP0 = OcamlTokenElementType("INFIXOP0")
    @JvmField
    val INFIXOP1 = OcamlTokenElementType("INFIXOP1")
    @JvmField
    val INFIXOP2 = OcamlTokenElementType("INFIXOP2")
    @JvmField
    val INFIXOP3 = OcamlTokenElementType("INFIXOP3")
    @JvmField
    val INFIXOP4 = OcamlTokenElementType("INFIXOP4")
    @JvmField
    val INHERIT = OcamlTokenElementType("INHERIT")
    @JvmField
    val INITIALIZER = OcamlTokenElementType("INITIALIZER")
    @JvmField
    val INT = OcamlTokenElementType("INT")
    @JvmField
    val INT32 = OcamlTokenElementType("INT32")
    @JvmField
    val INT64 = OcamlTokenElementType("INT64")
    @JvmField
    val LABEL = OcamlTokenElementType("LABEL")
    @JvmField
    val LAZY = OcamlTokenElementType("LAZY")
    @JvmField
    val LBRACE = OcamlTokenElementType("LBRACE")
    @JvmField
    val LBRACELESS = OcamlTokenElementType("LBRACELESS")
    @JvmField
    val LBRACKET = OcamlTokenElementType("LBRACKET")
    @JvmField
    val LBRACKETBAR = OcamlTokenElementType("LBRACKETBAR")
    @JvmField
    val LBRACKETLESS = OcamlTokenElementType("LBRACKETLESS")
    @JvmField
    val LBRACKETGREATER = OcamlTokenElementType("LBRACKETGREATER")
    @JvmField
    val LBRACKETPERCENT = OcamlTokenElementType("LBRACKETPERCENT")
    @JvmField
    val LBRACKETPERCENTPERCENT = OcamlTokenElementType("LBRACKETPERCENTPERCENT")
    @JvmField
    val LESS = OcamlTokenElementType("LESS")
    @JvmField
    val LESSMINUS = OcamlTokenElementType("LESSMINUS")
    @JvmField
    val LET = OcamlTokenElementType("LET")
    @JvmField
    val LIDENT = OcamlTokenElementType("LIDENT")
    @JvmField
    val LPAREN = OcamlTokenElementType("LPAREN")
    @JvmField
    val LBRACKETAT = OcamlTokenElementType("LBRACKETAT")
    @JvmField
    val LBRACKETATAT = OcamlTokenElementType("LBRACKETATAT")
    @JvmField
    val LBRACKETATATAT = OcamlTokenElementType("LBRACKETATATAT")
    @JvmField
    val MATCH = OcamlTokenElementType("MATCH")
    @JvmField
    val METHOD = OcamlTokenElementType("METHOD")
    @JvmField
    val MINUS = OcamlTokenElementType("MINUS")
    @JvmField
    val MINUSDOT = OcamlTokenElementType("MINUSDOT")
    @JvmField
    val MINUSGREATER = OcamlTokenElementType("MINUSGREATER")
    @JvmField
    val MODULE = OcamlTokenElementType("MODULE")
    @JvmField
    val MUTABLE = OcamlTokenElementType("MUTABLE")
    @JvmField
    val NATIVEINT = OcamlTokenElementType("NATIVEINT")
    @JvmField
    val NEW = OcamlTokenElementType("NEW")
    @JvmField
    val NONREC = OcamlTokenElementType("NONREC")
    @JvmField
    val OBJECT = OcamlTokenElementType("OBJECT")
    @JvmField
    val OF = OcamlTokenElementType("OF")
    @JvmField
    val OPEN = OcamlTokenElementType("OPEN")
    @JvmField
    val OPTLABEL = OcamlTokenElementType("OPTLABEL")
    @JvmField
    val OR = OcamlTokenElementType("OR")
    @JvmField
    val PERCENT = OcamlTokenElementType("PERCENT")
    @JvmField
    val PLUS = OcamlTokenElementType("PLUS")
    @JvmField
    val PLUSDOT = OcamlTokenElementType("PLUSDOT")
    @JvmField
    val PLUSEQ = OcamlTokenElementType("PLUSEQ")
    @JvmField
    val PREFIXOP = OcamlTokenElementType("PREFIXOP")
    @JvmField
    val PRIVATE = OcamlTokenElementType("PRIVATE")
    @JvmField
    val QUESTION = OcamlTokenElementType("QUESTION")
    @JvmField
    val QUOTE = OcamlTokenElementType("QUOTE")
    @JvmField
    val RBRACE = OcamlTokenElementType("RBRACE")
    @JvmField
    val RBRACKET = OcamlTokenElementType("RBRACKET")
    @JvmField
    val REC = OcamlTokenElementType("REC")
    @JvmField
    val RPAREN = OcamlTokenElementType("RPAREN")
    @JvmField
    val SEMI = OcamlTokenElementType("SEMI")
    @JvmField
    val SEMISEMI = OcamlTokenElementType("SEMISEMI")
    @JvmField
    val SHARP = OcamlTokenElementType("SHARP")
    @JvmField
    val SHARPOP = OcamlTokenElementType("SHARPOP")
    @JvmField
    val SIG = OcamlTokenElementType("SIG")
    @JvmField
    val STAR = OcamlTokenElementType("STAR")
    @JvmField
    val STRING = OcamlTokenElementType("STRING")
    @JvmField
    val STRUCT = OcamlTokenElementType("STRUCT")
    @JvmField
    val THEN = OcamlTokenElementType("THEN")
    @JvmField
    val TILDE = OcamlTokenElementType("TILDE")
    @JvmField
    val TO = OcamlTokenElementType("TO")
    @JvmField
    val TRUE = OcamlTokenElementType("TRUE")
    @JvmField
    val TRY = OcamlTokenElementType("TRY")
    @JvmField
    val TYPE = OcamlTokenElementType("TYPE")
    @JvmField
    val UIDENT = OcamlTokenElementType("UIDENT")
    @JvmField
    val UNDERSCORE = OcamlTokenElementType("UNDERSCORE")
    @JvmField
    val VAL = OcamlTokenElementType("VAL")
    @JvmField
    val VIRTUAL = OcamlTokenElementType("VIRTUAL")
    @JvmField
    val WHEN = OcamlTokenElementType("WHEN")
    @JvmField
    val WHILE = OcamlTokenElementType("WHILE")
    @JvmField
    val WITH = OcamlTokenElementType("WITH")
    @JvmField
    val COMMENT = OcamlTokenElementType("COMMENT")
    @JvmField
    val DOCSTRING = OcamlTokenElementType("DOCSTRING")

    @JvmField
    val SHEBANG_LINE = OcamlTokenElementType("SHEBANG_LINE")

    @JvmField
    val BADCHAR = OcamlTokenElementType("BADCHAR")

    @JvmField
    val BAD_LITERAL = OcamlTokenElementType("BAD_LITERAL")
}