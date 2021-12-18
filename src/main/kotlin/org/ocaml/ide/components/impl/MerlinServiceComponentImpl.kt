package org.ocaml.ide.components.impl

import com.intellij.openapi.editor.EditorFactory
import com.intellij.psi.PsiDocumentManager
import com.intellij.psi.PsiFile
import org.ocaml.ide.components.MerlinServiceComponent
import org.ocaml.ide.components.MerlinServiceDocumentListener
import org.ocaml.merlin.*

/**
 * Created by sidharthkuruvila on 24/05/16.
 */

class MerlinServiceComponentImpl : MerlinServiceComponent {

    var lastModifiedTimeStamp = -1L
    val merlin = Merlin.newInstance()
//    val msdl = MerlinServiceDocumentListener(merlin)

//    override fun getComponentName(): String {
//        return "ocaml.merlinservice"
//    }

//    override fun dispose() {
//        EditorFactory.getInstance().eventMulticaster.removeDocumentListener(msdl)
//    }
//
//    init {
//        EditorFactory.getInstance().eventMulticaster.addDocumentListener(msdl)
//    }

    override fun errors(file: PsiFile): List<MerlinError> {
        reloadFileIfModified(file)
        return merlin.errors(file.virtualFile.canonicalPath!!)
    }

    override fun completions(file: PsiFile, prefix: String, position: Position): List<CompletionEntry> {
        reloadFileIfModified(file)
        return merlin.complete(file.virtualFile.canonicalPath!!, prefix, position).entries
    }

    override fun locate(file: PsiFile, position: Position): LocateResponse {
        reloadFileIfModified(file)
        return merlin.locate(file.virtualFile.canonicalPath!!, position)
    }

    private fun reloadFileIfModified(file: PsiFile) {
        if (file.modificationStamp > lastModifiedTimeStamp) {
            println("modification time stamp in file${file.modificationStamp}")
            println("modification time stamp in service$lastModifiedTimeStamp")
            lastModifiedTimeStamp = file.modificationStamp
            val doc = PsiDocumentManager.getInstance(file.project).getCachedDocument(file)
            val filename = file.virtualFile.canonicalPath!!
            println("file name:$filename")
            //merlin.seekExact(filename, Position(1, 0))
            //merlin.drop(filename)
            merlin.tellSource(filename, file.text)
            doc?.putUserData(MerlinServiceDocumentListener.DOCUMENT_CHANGED, false)
        }

    }
}