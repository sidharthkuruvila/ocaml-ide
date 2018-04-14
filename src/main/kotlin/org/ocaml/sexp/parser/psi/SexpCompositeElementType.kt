package org.ocaml.sexp.parser.psi

import com.intellij.psi.tree.IElementType
import org.ocaml.sexp.SexpLanguage

class SexpCompositeElementType(s: String) : IElementType(s, SexpLanguage.INSTANCE)