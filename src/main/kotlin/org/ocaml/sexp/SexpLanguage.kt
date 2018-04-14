package org.ocaml.sexp

import com.intellij.lang.Language

class SexpLanguage : Language("Sexp") {
    companion object {
        val INSTANCE = SexpLanguage()
    }

}