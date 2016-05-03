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
    val KEY = IElementType("KEY", OcamlLanguage.INSTANCE)
    @JvmField
    val COMMENT = IElementType("KEY", OcamlLanguage.INSTANCE)
    @JvmField
    val SEPARATOR = IElementType("SEPARATOR", OcamlLanguage.INSTANCE)
    @JvmField
    val VALUE = IElementType("VALUE", OcamlLanguage.INSTANCE)
}