package org.ocaml.ide.components

import com.intellij.openapi.components.ApplicationComponent
import com.intellij.psi.PsiFile
import org.ocaml.merlin.CompletionEntry
import org.ocaml.merlin.LocateResponse
import org.ocaml.merlin.MerlinError
import org.ocaml.merlin.Position

/**
 * Created by sidharthkuruvila on 26/05/16.
 */
interface MerlinServiceComponent : ApplicationComponent {
    fun errors(file: PsiFile): List<MerlinError>
    fun completions(file: PsiFile, prefix: String, position: Position): List<CompletionEntry>
    fun locate(file: PsiFile, position: Position): LocateResponse
}