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
    val KEYWORD = IElementType("KEYWORD", OcamlLanguage.INSTANCE)
    @JvmField
    val COMMENT = IElementType("COMMENT", OcamlLanguage.INSTANCE)
    @JvmField
    val STRING = IElementType("IDENTIFIER", OcamlLanguage.INSTANCE)
    @JvmField
    val IDENTIFIER = IElementType("IDENTIFIER", OcamlLanguage.INSTANCE)
}