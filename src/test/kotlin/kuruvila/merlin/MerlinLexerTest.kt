package kuruvila.merlin

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.junit.Assert.*
import org.junit.Test

/**
 * Created by sidharthkuruvila on 03/05/16.
 */
class MerlinLexerTest {
    @Test
    fun testLexing() {
        val script = """let try ignore
        identifier x;;
        1 2.
        (* comment *)
        lsl + - * =
        "hello world"
        a.b
        Module
        """
        val merlin = merlinInstance()
        val lexer = MerlinLexer(merlin)
        lexer.start(script, 0, script.length)
        val result = mutableListOf<TokenValue>()
        lexer.advance()
        while (lexer.tokenType != null) {
            result.add(TokenValue(lexer.tokenType.toString(), lexer.tokenText, lexer.tokenStart, lexer.tokenEnd))
            lexer.advance()
        }

        val expected = listOf(
                TokenValue(type = "WHITESPACE", text = " ", start = 3, end = 4),
                TokenValue(type = "KEYWORD", text = "try", start = 4, end = 7),
                TokenValue(type = "WHITESPACE", text = " ", start = 7, end = 8),
                TokenValue(type = "IDENTIFIER", text = "ignore", start = 8, end = 14),
                TokenValue(type = "WHITESPACE", text = "\n        ", start = 14, end = 23),
                TokenValue(type = "IDENTIFIER", text = "identifier", start = 23, end = 33),
                TokenValue(type = "WHITESPACE", text = " ", start = 33, end = 34),
                TokenValue(type = "IDENTIFIER", text = "x", start = 34, end = 35),
                TokenValue(type = "SEMISEMI", text = ";;", start = 35, end = 37),
                TokenValue(type = "WHITESPACE", text = "\n        ", start = 37, end = 46),
                TokenValue(type = "INT", text = "1", start = 46, end = 47),
                TokenValue(type = "WHITESPACE", text = " ", start = 47, end = 48),
                TokenValue(type = "FLOAT", text = "2.", start = 48, end = 50),
                TokenValue(type = "WHITESPACE", text = "\n        (* comment ", start = 50, end = 70),
                TokenValue(type = "COMMENT", text = "*)", start = 70, end = 72),
                TokenValue(type = "WHITESPACE", text = "\n        ", start = 72, end = 81),
                TokenValue(type = "INFIXOP4", text = "lsl", start = 81, end = 84),
                TokenValue(type = "WHITESPACE", text = " ", start = 84, end = 85),
                TokenValue(type = "PLUS", text = "+", start = 85, end = 86),
                TokenValue(type = "WHITESPACE", text = " ", start = 86, end = 87),
                TokenValue(type = "MINUS", text = "-", start = 87, end = 88),
                TokenValue(type = "WHITESPACE", text = " ", start = 88, end = 89),
                TokenValue(type = "STAR", text = "*", start = 89, end = 90),
                TokenValue(type = "WHITESPACE", text = " ", start = 90, end = 91),
                TokenValue(type = "EQUAL", text = "=", start = 91, end = 92),
                TokenValue(type = "WHITESPACE", text = "\n        ", start = 92, end = 101),
                TokenValue(type = "IDENTIFIER", text = "\"hello world\"", start = 101, end = 114),
                TokenValue(type = "WHITESPACE", text = "\n        ", start = 114, end = 123),
                TokenValue(type = "IDENTIFIER", text = "a", start = 123, end = 124),
                TokenValue(type = "DOT", text = ".", start = 124, end = 125),
                TokenValue(type = "IDENTIFIER", text = "b", start = 125, end = 126),
                TokenValue(type = "WHITESPACE", text = "\n        ", start = 126, end = 135),
                TokenValue(type = "UIDENT", text = "Module", start = 135, end = 141),
                TokenValue(type = "WHITESPACE", text = "\n        ", start = 141, end = 150))
        assertEquals(expected, result)
    }

    private fun merlinInstance(): Merlin {
        val p = merlinProcess()
        val om = ObjectMapper()
        om.registerModule(KotlinModule())
        val m = Merlin(om, p)
        return m
    }

    private fun merlinProcess(): Process {
        val pb = ProcessBuilder("/Users/sidharthkuruvila/Code/ocaml_idea_plugin/merlin/ocamlmerlin")
        return pb.start()
    }
}

data class TokenValue(val type: String, val text: String, val start: Int, val end: Int)