package org.ocaml.merlin

import com.intellij.lexer.LexerBase
import com.intellij.openapi.diagnostic.Logger
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import org.ocaml.lang.OcamlLanguage
import org.ocaml.lang.lexer.OcamlTypes

/**
 * Facade over merlin's dump tokens operation that provides a way to
 * integrate with idea's lexing api.
 *
 * Note this currently only works with \n line separators
 * Note comments get messed up only the  *) get's picked up
 *
 */
class MerlinLexer(private val merlin: Merlin) : LexerBase() {

    private var source: CharSequence = ""
    private var currentToken: TokenWithIndex = TokenWithIndex("WHITESPACE", 0, 0)
    private var currentTokenIndex = 0
    private var tokens: List<TokenWithIndex> = emptyList()
    private var endIndex = 0
    private var currentTokenType = TokenType.WHITE_SPACE


    init {
        reset()
    }

    final fun reset(){
        source = ""
        currentToken = TokenWithIndex("WHITESPACE", 0, 0)
        currentTokenIndex = 0
        tokens = emptyList()
        endIndex = 0
        currentTokenType = TokenType.WHITE_SPACE
    }

    companion object {
        private val LOG = Logger.getInstance(MerlinLexer::class.java)
    }

    val keyWords = setOf("AND", "AS", "ASSERT", "BEGIN", "CLASS", "CONSTRAINT", "DO", "DONE", "DOWNTO", "ELSE", "END",
            "EXCEPTION", "EXTERNAL", "FALSE", "FOR", "FUN", "FUNCTION", "FUNCTOR", "IF", "IN", "INCLUDE", "INHERIT",
            "INITIALIZER", "LAZY", "LET", "MATCH", "METHOD", "MODULE", "MUTABLE", "NEW", "OBJECT", "OF", "OPEN", "OR",
            "PRIVATE", "REC", "SIG", "STRUCT", "THEN", "TO", "TRUE", "TRY", "TYPE", "VAL", "VIRTUAL", "WHEN", "WHILE",
            "WITH")

    override fun getTokenEnd(): Int {
        return currentToken.endPosition
    }

    override fun advance() {
        if (currentTokenIndex < endIndex) {
            currentToken = tokens[currentTokenIndex]


            currentTokenType = when (currentToken.token.toString()) {
                "AMPERAMPER" -> OcamlTypes.AMPERAMPER
                "AMPERSAND" -> OcamlTypes.AMPERSAND
                "AND" -> OcamlTypes.AND
                "AS" -> OcamlTypes.AS
                "ASSERT" -> OcamlTypes.ASSERT
                "BACKQUOTE" -> OcamlTypes.BACKQUOTE
                "BANG" -> OcamlTypes.BANG
                "BAR" -> OcamlTypes.BAR
                "BARBAR" -> OcamlTypes.BARBAR
                "BARRBRACKET" -> OcamlTypes.BARRBRACKET
                "BEGIN" -> OcamlTypes.BEGIN
                "CHAR" -> OcamlTypes.CHAR
                "CLASS" -> OcamlTypes.CLASS
                "COLON" -> OcamlTypes.COLON
                "COLONCOLON" -> OcamlTypes.COLONCOLON
                "COLONEQUAL" -> OcamlTypes.COLONEQUAL
                "COLONGREATER" -> OcamlTypes.COLONGREATER
                "COMMA" -> OcamlTypes.COMMA
                "CONSTRAINT" -> OcamlTypes.CONSTRAINT
                "DO" -> OcamlTypes.DO
                "DONE" -> OcamlTypes.DONE
                "DOT" -> OcamlTypes.DOT
                "DOTDOT" -> OcamlTypes.DOTDOT
                "DOWNTO" -> OcamlTypes.DOWNTO
                "ELSE" -> OcamlTypes.ELSE
                "END" -> OcamlTypes.END
                "EOF" -> OcamlTypes.EOF
                "EQUAL" -> OcamlTypes.EQUAL
                "EXCEPTION" -> OcamlTypes.EXCEPTION
                "EXTERNAL" -> OcamlTypes.EXTERNAL
                "FALSE" -> OcamlTypes.FALSE
                "FLOAT" -> OcamlTypes.FLOAT
                "FOR" -> OcamlTypes.FOR
                "FUN" -> OcamlTypes.FUN
                "FUNCTION" -> OcamlTypes.FUNCTION
                "FUNCTOR" -> OcamlTypes.FUNCTOR
                "GREATER" -> OcamlTypes.GREATER
                "GREATERRBRACE" -> OcamlTypes.GREATERRBRACE
                "GREATERRBRACKET" -> OcamlTypes.GREATERRBRACKET
                "IF" -> OcamlTypes.IF
                "IN" -> OcamlTypes.IN
                "INCLUDE" -> OcamlTypes.INCLUDE
                "INFIXOP0" -> OcamlTypes.INFIXOP0
                "INFIXOP1" -> OcamlTypes.INFIXOP1
                "INFIXOP2" -> OcamlTypes.INFIXOP2
                "INFIXOP3" -> OcamlTypes.INFIXOP3
                "INFIXOP4" -> OcamlTypes.INFIXOP4
                "INHERIT" -> OcamlTypes.INHERIT
                "INITIALIZER" -> OcamlTypes.INITIALIZER
                "INT" -> OcamlTypes.INT
                "INT32" -> OcamlTypes.INT32
                "INT64" -> OcamlTypes.INT64
                "LABEL" -> OcamlTypes.LABEL_OP
                "LAZY" -> OcamlTypes.LAZY
                "LBRACE" -> OcamlTypes.LBRACE
                "LBRACELESS" -> OcamlTypes.LBRACELESS
                "LBRACKET" -> OcamlTypes.LBRACKET
                "LBRACKETBAR" -> OcamlTypes.LBRACKETBAR
                "LBRACKETLESS" -> OcamlTypes.LBRACKETLESS
                "LBRACKETGREATER" -> OcamlTypes.LBRACKETGREATER
                "LBRACKETPERCENT" -> OcamlTypes.LBRACKETPERCENT
                "LBRACKETPERCENTPERCENT" -> OcamlTypes.LBRACKETPERCENTPERCENT
                "LESS" -> OcamlTypes.LESS
                "LESSMINUS" -> OcamlTypes.LESSMINUS
                "LET" -> OcamlTypes.LET
                "LIDENT" -> OcamlTypes.LIDENT
                "LPAREN" -> OcamlTypes.LPAREN
                "LBRACKETAT" -> OcamlTypes.LBRACKETAT
                "LBRACKETATAT" -> OcamlTypes.LBRACKETATAT
                "LBRACKETATATAT" -> OcamlTypes.LBRACKETATATAT
                "MATCH" -> OcamlTypes.MATCH
                "METHOD" -> OcamlTypes.METHOD_KEYWORD
                "MINUS" -> OcamlTypes.MINUS
                "MINUSDOT" -> OcamlTypes.MINUSDOT
                "MINUSGREATER" -> OcamlTypes.MINUSGREATER
                "MODULE" -> OcamlTypes.MODULE
                "MUTABLE" -> OcamlTypes.MUTABLE
                "NATIVEINT" -> OcamlTypes.NATIVEINT
                "NEW" -> OcamlTypes.NEW
                "NONREC" -> OcamlTypes.NONREC
                "OBJECT" -> OcamlTypes.OBJECT
                "OF" -> OcamlTypes.OF
                "OPEN" -> OcamlTypes.OPEN
                "OPTLABEL" -> OcamlTypes.OPTLABEL
                "OR" -> OcamlTypes.OR
                "PERCENT" -> OcamlTypes.PERCENT
                "PLUS" -> OcamlTypes.PLUS
                "PLUSDOT" -> OcamlTypes.PLUSDOT
                "PLUSEQ" -> OcamlTypes.PLUSEQ
                "PREFIXOP" -> OcamlTypes.PREFIXOP
                "PRIVATE" -> OcamlTypes.PRIVATE
                "QUESTION" -> OcamlTypes.QUESTION
                "QUOTE" -> OcamlTypes.QUOTE
                "RBRACE" -> OcamlTypes.RBRACE
                "RBRACKET" -> OcamlTypes.RBRACKET
                "REC" -> OcamlTypes.REC
                "RPAREN" -> OcamlTypes.RPAREN
                "SEMI" -> OcamlTypes.SEMI
                "SEMISEMI" -> OcamlTypes.SEMISEMI
                "SHARP" -> OcamlTypes.SHARP
                "SHARPOP" -> OcamlTypes.SHARPOP
                "SIG" -> OcamlTypes.SIG
                "STAR" -> OcamlTypes.STAR
                "STRING" -> OcamlTypes.STRING
                "STRUCT" -> OcamlTypes.STRUCT
                "THEN" -> OcamlTypes.THEN
                "TILDE" -> OcamlTypes.TILDE
                "TO" -> OcamlTypes.TO
                "TRUE" -> OcamlTypes.TRUE
                "TRY" -> OcamlTypes.TRY
                "TYPE" -> OcamlTypes.TYPE
                "UIDENT" -> OcamlTypes.UIDENT
                "UNDERSCORE" -> OcamlTypes.UNDERSCORE
                "VAL" -> OcamlTypes.VAL
                "VIRTUAL" -> OcamlTypes.VIRTUAL
                "WHEN" -> OcamlTypes.WHEN
                "WHILE" -> OcamlTypes.WHILE
                "WITH" -> OcamlTypes.WITH
                "COMMENT" -> OcamlTypes.COMMENT
                "DOCSTRING" -> OcamlTypes.DOCSTRING
                else -> IElementType(currentToken.token, OcamlLanguage.INSTANCE)
            }
        }
        currentTokenIndex += 1
    }

    override fun getTokenType(): IElementType? {
        if (currentTokenIndex > endIndex) {
            return null
        }
        return currentTokenType
    }

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {

        source = buffer
        _state = initialState

        if(buffer.length != 0) {
            tokens = tokensWithIndex(buffer)

            updateCurrentTokenIndex(startOffset)
            updateEndOffset(endOffset)
            advance()
        } else {
            reset()
        }

    }

    private fun updateCurrentTokenIndex(startOffset: Int) {
        for (i in tokens.size - 1 downTo 0) {
            if (tokens[i].startPosition <= startOffset) {
                currentTokenIndex = i
                return
            }
        }
        currentTokenIndex = 0
    }

    private fun updateEndOffset(endOffset: Int) {
        endIndex = tokens.size
    }

    override fun getBufferSequence(): CharSequence {
        return source
    }

    override fun getBufferEnd(): Int {
        return source.length
    }


    override fun getTokenStart(): Int {
        return currentToken.startPosition
    }

    private var _state = 0
    override fun getState(): Int {
        return _state
    }

    private fun tokensWithIndex(source: CharSequence): List<TokenWithIndex> {

        fun nextIndex(curIndex: Int, curPos: Position, nextPos: Position): Int {
            var i = curIndex
            var curLine = curPos.line
            var curCol = curPos.col
            while (i <= source.length) {
                if (nextPos.line == curLine && nextPos.col == curCol) {
                    return i
                }
                if (source[i] == '\n') {
                    curLine += 1
                    curCol = 0
                } else {
                    curCol += 1
                }
                i++
               }
            throw IllegalStateException("The line number ${nextPos.line} and culumn number ${nextPos.col} are outside the source length ${source.length}")
        }

        val merlinTokens = merlinTokens(source)
        val twps = mutableListOf<TokenWithIndex>()
        var curIndex = 0
        var curPos = Position(line = 1, col = 0)
        for (mt in merlinTokens) {



            val start = nextIndex(curIndex, curPos, mt.start)
            val end = nextIndex(start, mt.start, mt.end)
            if(curIndex < start) {
                twps.add(TokenWithIndex(token = "WHITESPACE", startPosition = curIndex, endPosition = start))
            }
            twps.add(TokenWithIndex(token = mt.token, startPosition = start, endPosition = end))
            curIndex = end
            curPos = mt.end
        }
        if(curIndex < source.length) {
            twps.add(TokenWithIndex(token = "WHITESPACE", startPosition = curIndex, endPosition = source.length))
        }

        return twps

    }

    private fun merlinTokens(source: CharSequence): List<Token> {
        merlin.seekExact(Position(1, 0))
        merlin.drop()
        merlin.tellSource(source.toString() + " ")
        val merlinTokens = merlin.dumpTokens()
        return merlinTokens
    }
}

data class TokenWithIndex(val token: String, val startPosition: Int, val endPosition: Int)