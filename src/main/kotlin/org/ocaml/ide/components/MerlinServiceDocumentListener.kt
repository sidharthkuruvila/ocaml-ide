package org.ocaml.ide.components

import com.intellij.openapi.editor.event.DocumentEvent
import com.intellij.openapi.editor.event.DocumentListener
import com.intellij.openapi.util.Key
import org.ocaml.merlin.Merlin

/**
 * Created by sidharthkuruvila on 24/05/16.
 */

class MerlinServiceDocumentListener(val merlin: Merlin) : DocumentListener {

    companion object {
        val DOCUMENT_CHANGED = Key<Boolean>("DOCUMENT_CHANGED")
    }

    override fun documentChanged(event: DocumentEvent) {
    }

    override fun beforeDocumentChange(event: DocumentEvent) {
        event.document.putUserData(DOCUMENT_CHANGED, true)
    }

}