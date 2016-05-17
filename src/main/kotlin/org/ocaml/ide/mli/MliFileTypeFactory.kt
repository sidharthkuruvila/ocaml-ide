package org.ocaml.ide.mli

import com.intellij.openapi.fileTypes.FileTypeConsumer
import com.intellij.openapi.fileTypes.FileTypeFactory
import org.ocaml.lang.MlFileType

/**
 * Created by sidharthkuruvila on 17/05/16.
 */
class MliFileTypeFactory  : FileTypeFactory() {
    override fun createFileTypes(fileTypeConsumer: FileTypeConsumer) {
        fileTypeConsumer.consume(MliFileType, "mli");
    }
}