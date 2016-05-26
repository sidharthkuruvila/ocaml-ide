package org.ocaml.ide.components

import com.intellij.openapi.components.ApplicationComponent
import com.intellij.openapi.vfs.VirtualFile
import org.ocaml.merlin.MerlinError

/**
 * Created by sidharthkuruvila on 26/05/16.
 */
interface MerlinServiceComponent : ApplicationComponent {
    fun errors(file: VirtualFile): List<MerlinError>
}