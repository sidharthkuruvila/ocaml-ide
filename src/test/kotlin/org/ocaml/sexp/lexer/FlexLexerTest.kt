package org.ocaml.sexp.lexer

import com.intellij.openapi.util.io.FileUtil
import org.junit.Assert
import org.junit.Test
import org.ocaml.sexp.lexer._SexpLexer
import java.io.File

/**
 * Created by sidharthkuruvila on 09/05/16.
 */
class FlexLexerTest {
    @Test
    fun testTokens(){
        val src = FileUtil.loadFile(File("src/test/resources/org/ocaml/sexp/lexer/flextokens.txt"))
        println(src)
        val lexer = _SexpLexer(null)
        lexer.reset(src, 0, src.length, 0)
        val sb = StringBuffer()
        var index = 0;
        while(true) {
            val t = lexer.advance()
            if(t == null){
                break
            }
            //Check if the start index of the curent token is the same as the end index of the previous token
            if(lexer.tokenStart != index){
                Assert.fail("Token ${t} was expected to start at index ${index} instead started at ${lexer.tokenStart}")
            }
            index = lexer.tokenEnd

            sb.append(t.toString())
            sb.append("\n")
        }
        //Check if all tokens are generated with the correct type
        val exp = FileUtil.loadFile(File("src/test/resources/org/ocaml/sexp/lexer/expected_token_types.txt"))
        Assert.assertEquals(exp, sb.toString())
    }

}