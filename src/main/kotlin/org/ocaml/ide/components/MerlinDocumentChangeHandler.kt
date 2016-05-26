package org.ocaml.ide.components

import com.intellij.openapi.editor.event.DocumentEvent
import com.intellij.openapi.fileEditor.FileDocumentManager
import org.ocaml.merlin.Merlin
import org.ocaml.merlin.Position

/**
 * Created by sidharthkuruvila on 25/05/16.
 */

data class MerlinDocumentChangeHandler(val merlin: Merlin, val event: DocumentEvent) {

    val doc = event.document
    val filename = FileDocumentManager.getInstance().getFile(doc)!!.canonicalPath!!

    fun handle(){
        if(event.isWholeTextReplaced){
            fullUpdate();
        }
        else if(isTagged()){
            diffUpdate()
        } else {
            fullUpdate()
        }
    }

    private fun diffUpdate() {
        merlin.seekExact(filename, Position(1, 0))
        merlin.drop(filename)
        merlin.tellSource(filename, doc.charsSequence)
    }

    private fun fullUpdate() {
        merlin.seekExact(filename, Position(1, 0))
        merlin.drop(filename)
        merlin.tellSource(filename, doc.charsSequence)
    }

    private fun isTagged(): Boolean {
        return false;
    }


}