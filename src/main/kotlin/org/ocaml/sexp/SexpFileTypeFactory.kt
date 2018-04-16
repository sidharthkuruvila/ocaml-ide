package org.ocaml.sexp

import com.intellij.openapi.fileTypes.FileTypeConsumer
import com.intellij.openapi.fileTypes.FileTypeFactory
import org.ocaml.jbuild.JbuilderFileType

object JbuilderFileTypeFactory : FileTypeFactory() {
    override fun createFileTypes(consumer: FileTypeConsumer) {
        consumer.consume(JbuilderFileType.INSTANCE)
    }

}