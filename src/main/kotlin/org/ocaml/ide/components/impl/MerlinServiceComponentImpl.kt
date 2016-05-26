package org.ocaml.ide.components.impl

import com.intellij.openapi.editor.EditorFactory
import com.intellij.openapi.vfs.VirtualFile
import org.ocaml.ide.components.MerlinServiceComponent
import org.ocaml.ide.components.MerlinServiceDocumentListener
import org.ocaml.merlin.Merlin
import org.ocaml.merlin.MerlinError

/**
 * Created by sidharthkuruvila on 24/05/16.
 */

class MerlinServiceComponentImpl : MerlinServiceComponent {

    val merlin = Merlin.newInstance()
    val msdl = MerlinServiceDocumentListener(merlin)

    override fun getComponentName(): String {
        return "ocaml.merlinservice"
    }

    override fun disposeComponent() {
        EditorFactory.getInstance().eventMulticaster.removeDocumentListener(msdl)
    }

    override fun initComponent() {
        EditorFactory.getInstance().eventMulticaster.addDocumentListener(msdl)
    }

    override fun errors(file: VirtualFile): List<MerlinError> {
        return merlin.errors(file.canonicalPath!!)
    }
}