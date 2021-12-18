package org.ocaml.ide.components.impl

import com.intellij.psi.PsiFile
import org.ocaml.ide.components.MerlinServiceComponent
import org.ocaml.merlin.*

/**
 * Created by sidharthkuruvila on 24/05/16.
 */

class MerlinServiceComponentImpl : MerlinServiceComponent {

    val merlin = Merlin3.getInstance()

    override fun errors(file: PsiFile): List<MerlinError> {
        return merlin.errors(file.virtualFile.canonicalPath!!, file.text)
    }

    override fun completions(file: PsiFile, prefix: String, position: Position): List<CompletionEntry> {
        return merlin.complete(file.virtualFile.canonicalPath!!, file.text, prefix, position).entries
    }

    override fun locate(file: PsiFile, position: Position): LocateResponse {
        return merlin.locate(file.virtualFile.canonicalPath!!, file.text, position)
    }
}
