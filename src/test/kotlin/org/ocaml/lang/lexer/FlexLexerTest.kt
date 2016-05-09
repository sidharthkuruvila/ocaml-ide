package org.ocaml.lang.lexer

import com.intellij.openapi.util.io.FileUtil
import org.junit.Assert
import org.junit.Test
import java.io.File

/**
 * Created by sidharthkuruvila on 09/05/16.
 */
class FlexLexerTest {
    @Test
    fun testTokens(){
        val src = FileUtil.loadFile(File("src/test/resources/org/ocaml/lang/lexer/flextokens.txt"))
        println(src)
        val lexer = _OcamlLexer(null)
        lexer.reset(src, 0, src.length, 0)
        val sb = StringBuffer()
        while(true) {
            val t = lexer.advance()
            if(t == null){
                break
            }
            sb.append(t.toString())
            sb.append("\n")
        }
        val exp = FileUtil.loadFile(File("src/test/resources/org/ocaml/lang/lexer/expected_token_types.txt"))
        Assert.assertEquals(exp, sb.toString())
    }


}