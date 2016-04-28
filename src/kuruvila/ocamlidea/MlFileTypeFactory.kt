package kuruvila.ocamlidea

import com.intellij.openapi.fileTypes.FileTypeConsumer
import com.intellij.openapi.fileTypes.FileTypeFactory

/**
 * Created by sidharthkuruvila on 27/04/16.
 */
class MlFileTypeFactory : FileTypeFactory() {
    override fun createFileTypes(fileTypeConsumer: FileTypeConsumer) {
        fileTypeConsumer.consume(MlFileType.INSTANCE, "ml");
    }
}