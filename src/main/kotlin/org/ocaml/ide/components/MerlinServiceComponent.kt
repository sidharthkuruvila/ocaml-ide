package org.ocaml.ide.components

import com.intellij.openapi.components.ApplicationComponent
import com.intellij.openapi.vfs.VirtualFile
import org.ocaml.merlin.CompletionEntry
import org.ocaml.merlin.MerlinError
import org.ocaml.merlin.Position

/**
 * Created by sidharthkuruvila on 26/05/16.
 */
interface MerlinServiceComponent : ApplicationComponent {
    fun errors(file: VirtualFile): List<MerlinError>
    fun completions(file: VirtualFile, prefix: String, position: Position): List<CompletionEntry>
}