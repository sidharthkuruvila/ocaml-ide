package org.ocaml.lang.parser.psi

import com.intellij.psi.tree.IElementType
import org.ocaml.lang.OcamlLanguage

/**
 * Created by sidharthkuruvila on 10/05/16.
 */
class OcamlCompositeElementType(s: String) : IElementType(s, OcamlLanguage.INSTANCE)