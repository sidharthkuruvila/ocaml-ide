package kuruvila.ocamlidea.lexer

import com.intellij.lang.Language
import com.intellij.psi.tree.IElementType
import kuruvila.ocamlidea.OcamlLanguage

/**
 * Created by sidharthkuruvila on 02/05/16.
 */

//class SimpleTypes(name: String): IElementType(name, Language.ANY) {
//
//}

object OcamlTypes {

    @JvmField
    val AMPERAMPER = IElementType("AMPERAMPER", OcamlLanguage.INSTANCE)
    @JvmField
    val AMPERSAND = IElementType("AMPERSAND", OcamlLanguage.INSTANCE)
    @JvmField
    val AND = IElementType("AND", OcamlLanguage.INSTANCE)
    @JvmField
    val AS = IElementType("AS", OcamlLanguage.INSTANCE)
    @JvmField
    val ASSERT = IElementType("ASSERT", OcamlLanguage.INSTANCE)
    @JvmField
    val BACKQUOTE = IElementType("BACKQUOTE", OcamlLanguage.INSTANCE)
    @JvmField
    val BANG = IElementType("BANG", OcamlLanguage.INSTANCE)
    @JvmField
    val BAR = IElementType("BAR", OcamlLanguage.INSTANCE)
    @JvmField
    val BARBAR = IElementType("BARBAR", OcamlLanguage.INSTANCE)
    @JvmField
    val BARRBRACKET = IElementType("BARRBRACKET", OcamlLanguage.INSTANCE)
    @JvmField
    val BEGIN = IElementType("BEGIN", OcamlLanguage.INSTANCE)
    @JvmField
    val CHAR = IElementType("CHAR", OcamlLanguage.INSTANCE)
    @JvmField
    val CLASS = IElementType("CLASS", OcamlLanguage.INSTANCE)
    @JvmField
    val COLON = IElementType("COLON", OcamlLanguage.INSTANCE)
    @JvmField
    val COLONCOLON = IElementType("COLONCOLON", OcamlLanguage.INSTANCE)
    @JvmField
    val COLONEQUAL = IElementType("COLONEQUAL", OcamlLanguage.INSTANCE)
    @JvmField
    val COLONGREATER = IElementType("COLONGREATER", OcamlLanguage.INSTANCE)
    @JvmField
    val COMMA = IElementType("COMMA", OcamlLanguage.INSTANCE)
    @JvmField
    val CONSTRAINT = IElementType("CONSTRAINT", OcamlLanguage.INSTANCE)
    @JvmField
    val DO = IElementType("DO", OcamlLanguage.INSTANCE)
    @JvmField
    val DONE = IElementType("DONE", OcamlLanguage.INSTANCE)
    @JvmField
    val DOT = IElementType("DOT", OcamlLanguage.INSTANCE)
    @JvmField
    val DOTDOT = IElementType("DOTDOT", OcamlLanguage.INSTANCE)
    @JvmField
    val DOWNTO = IElementType("DOWNTO", OcamlLanguage.INSTANCE)
    @JvmField
    val ELSE = IElementType("ELSE", OcamlLanguage.INSTANCE)
    @JvmField
    val END = IElementType("END", OcamlLanguage.INSTANCE)
    @JvmField
    val EOF = IElementType("EOF", OcamlLanguage.INSTANCE)
    @JvmField
    val EQUAL = IElementType("EQUAL", OcamlLanguage.INSTANCE)
    @JvmField
    val EXCEPTION = IElementType("EXCEPTION", OcamlLanguage.INSTANCE)
    @JvmField
    val EXTERNAL = IElementType("EXTERNAL", OcamlLanguage.INSTANCE)
    @JvmField
    val FALSE = IElementType("FALSE", OcamlLanguage.INSTANCE)
    @JvmField
    val FLOAT = IElementType("FLOAT", OcamlLanguage.INSTANCE)
    @JvmField
    val FOR = IElementType("FOR", OcamlLanguage.INSTANCE)
    @JvmField
    val FUN = IElementType("FUN", OcamlLanguage.INSTANCE)
    @JvmField
    val FUNCTION = IElementType("FUNCTION", OcamlLanguage.INSTANCE)
    @JvmField
    val FUNCTOR = IElementType("FUNCTOR", OcamlLanguage.INSTANCE)
    @JvmField
    val GREATER = IElementType("GREATER", OcamlLanguage.INSTANCE)
    @JvmField
    val GREATERRBRACE = IElementType("GREATERRBRACE", OcamlLanguage.INSTANCE)
    @JvmField
    val GREATERRBRACKET = IElementType("GREATERRBRACKET", OcamlLanguage.INSTANCE)
    @JvmField
    val IF = IElementType("IF", OcamlLanguage.INSTANCE)
    @JvmField
    val IN = IElementType("IN", OcamlLanguage.INSTANCE)
    @JvmField
    val INCLUDE = IElementType("INCLUDE", OcamlLanguage.INSTANCE)
    @JvmField
    val INFIXOP0 = IElementType("INFIXOP0", OcamlLanguage.INSTANCE)
    @JvmField
    val INFIXOP1 = IElementType("INFIXOP1", OcamlLanguage.INSTANCE)
    @JvmField
    val INFIXOP2 = IElementType("INFIXOP2", OcamlLanguage.INSTANCE)
    @JvmField
    val INFIXOP3 = IElementType("INFIXOP3", OcamlLanguage.INSTANCE)
    @JvmField
    val INFIXOP4 = IElementType("INFIXOP4", OcamlLanguage.INSTANCE)
    @JvmField
    val INHERIT = IElementType("INHERIT", OcamlLanguage.INSTANCE)
    @JvmField
    val INITIALIZER = IElementType("INITIALIZER", OcamlLanguage.INSTANCE)
    @JvmField
    val INT = IElementType("INT", OcamlLanguage.INSTANCE)
    @JvmField
    val INT32 = IElementType("INT32", OcamlLanguage.INSTANCE)
    @JvmField
    val INT64 = IElementType("INT64", OcamlLanguage.INSTANCE)
    @JvmField
    val LABEL = IElementType("LABEL", OcamlLanguage.INSTANCE)
    @JvmField
    val LAZY = IElementType("LAZY", OcamlLanguage.INSTANCE)
    @JvmField
    val LBRACE = IElementType("LBRACE", OcamlLanguage.INSTANCE)
    @JvmField
    val LBRACELESS = IElementType("LBRACELESS", OcamlLanguage.INSTANCE)
    @JvmField
    val LBRACKET = IElementType("LBRACKET", OcamlLanguage.INSTANCE)
    @JvmField
    val LBRACKETBAR = IElementType("LBRACKETBAR", OcamlLanguage.INSTANCE)
    @JvmField
    val LBRACKETLESS = IElementType("LBRACKETLESS", OcamlLanguage.INSTANCE)
    @JvmField
    val LBRACKETGREATER = IElementType("LBRACKETGREATER", OcamlLanguage.INSTANCE)
    @JvmField
    val LBRACKETPERCENT = IElementType("LBRACKETPERCENT", OcamlLanguage.INSTANCE)
    @JvmField
    val LBRACKETPERCENTPERCENT = IElementType("LBRACKETPERCENTPERCENT", OcamlLanguage.INSTANCE)
    @JvmField
    val LESS = IElementType("LESS", OcamlLanguage.INSTANCE)
    @JvmField
    val LESSMINUS = IElementType("LESSMINUS", OcamlLanguage.INSTANCE)
    @JvmField
    val LET = IElementType("LET", OcamlLanguage.INSTANCE)
    @JvmField
    val LIDENT = IElementType("LIDENT", OcamlLanguage.INSTANCE)
    @JvmField
    val LPAREN = IElementType("LPAREN", OcamlLanguage.INSTANCE)
    @JvmField
    val LBRACKETAT = IElementType("LBRACKETAT", OcamlLanguage.INSTANCE)
    @JvmField
    val LBRACKETATAT = IElementType("LBRACKETATAT", OcamlLanguage.INSTANCE)
    @JvmField
    val LBRACKETATATAT = IElementType("LBRACKETATATAT", OcamlLanguage.INSTANCE)
    @JvmField
    val MATCH = IElementType("MATCH", OcamlLanguage.INSTANCE)
    @JvmField
    val METHOD = IElementType("METHOD", OcamlLanguage.INSTANCE)
    @JvmField
    val MINUS = IElementType("MINUS", OcamlLanguage.INSTANCE)
    @JvmField
    val MINUSDOT = IElementType("MINUSDOT", OcamlLanguage.INSTANCE)
    @JvmField
    val MINUSGREATER = IElementType("MINUSGREATER", OcamlLanguage.INSTANCE)
    @JvmField
    val MODULE = IElementType("MODULE", OcamlLanguage.INSTANCE)
    @JvmField
    val MUTABLE = IElementType("MUTABLE", OcamlLanguage.INSTANCE)
    @JvmField
    val NATIVEINT = IElementType("NATIVEINT", OcamlLanguage.INSTANCE)
    @JvmField
    val NEW = IElementType("NEW", OcamlLanguage.INSTANCE)
    @JvmField
    val NONREC = IElementType("NONREC", OcamlLanguage.INSTANCE)
    @JvmField
    val OBJECT = IElementType("OBJECT", OcamlLanguage.INSTANCE)
    @JvmField
    val OF = IElementType("OF", OcamlLanguage.INSTANCE)
    @JvmField
    val OPEN = IElementType("OPEN", OcamlLanguage.INSTANCE)
    @JvmField
    val OPTLABEL = IElementType("OPTLABEL", OcamlLanguage.INSTANCE)
    @JvmField
    val OR = IElementType("OR", OcamlLanguage.INSTANCE)
    @JvmField
    val PERCENT = IElementType("PERCENT", OcamlLanguage.INSTANCE)
    @JvmField
    val PLUS = IElementType("PLUS", OcamlLanguage.INSTANCE)
    @JvmField
    val PLUSDOT = IElementType("PLUSDOT", OcamlLanguage.INSTANCE)
    @JvmField
    val PLUSEQ = IElementType("PLUSEQ", OcamlLanguage.INSTANCE)
    @JvmField
    val PREFIXOP = IElementType("PREFIXOP", OcamlLanguage.INSTANCE)
    @JvmField
    val PRIVATE = IElementType("PRIVATE", OcamlLanguage.INSTANCE)
    @JvmField
    val QUESTION = IElementType("QUESTION", OcamlLanguage.INSTANCE)
    @JvmField
    val QUOTE = IElementType("QUOTE", OcamlLanguage.INSTANCE)
    @JvmField
    val RBRACE = IElementType("RBRACE", OcamlLanguage.INSTANCE)
    @JvmField
    val RBRACKET = IElementType("RBRACKET", OcamlLanguage.INSTANCE)
    @JvmField
    val REC = IElementType("REC", OcamlLanguage.INSTANCE)
    @JvmField
    val RPAREN = IElementType("RPAREN", OcamlLanguage.INSTANCE)
    @JvmField
    val SEMI = IElementType("SEMI", OcamlLanguage.INSTANCE)
    @JvmField
    val SEMISEMI = IElementType("SEMISEMI", OcamlLanguage.INSTANCE)
    @JvmField
    val SHARP = IElementType("SHARP", OcamlLanguage.INSTANCE)
    @JvmField
    val SHARPOP = IElementType("SHARPOP", OcamlLanguage.INSTANCE)
    @JvmField
    val SIG = IElementType("SIG", OcamlLanguage.INSTANCE)
    @JvmField
    val STAR = IElementType("STAR", OcamlLanguage.INSTANCE)
    @JvmField
    val STRING = IElementType("STRING", OcamlLanguage.INSTANCE)
    @JvmField
    val STRUCT = IElementType("STRUCT", OcamlLanguage.INSTANCE)
    @JvmField
    val THEN = IElementType("THEN", OcamlLanguage.INSTANCE)
    @JvmField
    val TILDE = IElementType("TILDE", OcamlLanguage.INSTANCE)
    @JvmField
    val TO = IElementType("TO", OcamlLanguage.INSTANCE)
    @JvmField
    val TRUE = IElementType("TRUE", OcamlLanguage.INSTANCE)
    @JvmField
    val TRY = IElementType("TRY", OcamlLanguage.INSTANCE)
    @JvmField
    val TYPE = IElementType("TYPE", OcamlLanguage.INSTANCE)
    @JvmField
    val UIDENT = IElementType("UIDENT", OcamlLanguage.INSTANCE)
    @JvmField
    val UNDERSCORE = IElementType("UNDERSCORE", OcamlLanguage.INSTANCE)
    @JvmField
    val VAL = IElementType("VAL", OcamlLanguage.INSTANCE)
    @JvmField
    val VIRTUAL = IElementType("VIRTUAL", OcamlLanguage.INSTANCE)
    @JvmField
    val WHEN = IElementType("WHEN", OcamlLanguage.INSTANCE)
    @JvmField
    val WHILE = IElementType("WHILE", OcamlLanguage.INSTANCE)
    @JvmField
    val WITH = IElementType("WITH", OcamlLanguage.INSTANCE)
    @JvmField
    val COMMENT = IElementType("COMMENT", OcamlLanguage.INSTANCE)
    @JvmField
    val DOCSTRING = IElementType("DOCSTRING", OcamlLanguage.INSTANCE)


}