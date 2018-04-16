package org.ocaml.jbuild.parser.psi

import com.intellij.psi.tree.IElementType
import org.ocaml.jbuild.JbuilderLanguage

class JbuildCompositeElementType(s: String) : IElementType(s, JbuilderLanguage)