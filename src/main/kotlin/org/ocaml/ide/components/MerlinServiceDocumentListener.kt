package org.ocaml.ide.components

import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.editor.event.DocumentEvent
import com.intellij.openapi.editor.event.DocumentListener
import com.intellij.openapi.fileEditor.FileDocumentManager
import org.ocaml.merlin.Merlin

/**
 * Created by sidharthkuruvila on 24/05/16.
 */

class MerlinServiceDocumentListener(val merlin: Merlin) : DocumentListener {
    val merlinFileTypes = setOf("ml", "mli")

    companion object {
        private val LOG = Logger.getInstance(MerlinServiceDocumentListener::class.java)
    }

    override fun documentChanged(event: DocumentEvent) {
        handle(event)

    }

    override fun beforeDocumentChange(event: DocumentEvent) {
        handle(event)
    }

    private fun handle(event: DocumentEvent) {
        val doc = event.document
        val fn = FileDocumentManager.getInstance().getFile(doc)

        if (fn == null || !merlinFileTypes.contains(fn.extension)) {
            return;
        }
        val mdch = MerlinDocumentChangeHandler(merlin, event)
        mdch.handle()

        LOG.info("Text changed from ${event.oldFragment} to ${event.newFragment}")
    }

}