package org.ocaml.ide.highlighter

import com.intellij.lang.annotation.AnnotationHolder
import com.intellij.lang.annotation.ExternalAnnotator
import com.intellij.lang.annotation.HighlightSeverity
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.diagnostic.Logger
import com.intellij.openapi.util.TextRange
import com.intellij.psi.PsiFile
import org.jetbrains.annotations.NotNull
import org.ocaml.ide.components.MerlinServiceComponent
import org.ocaml.ide.runconfig.OcamlRunner
import org.ocaml.merlin.MerlinError
import org.ocaml.util.LineNumbering

/**
 * Created by sidharthkuruvila on 26/05/16.
 */
class MerlinErrorHighlightingAnnotator : ExternalAnnotator<MerlinInfo, Results>() {

    companion object {
        private val LOG = Logger.getInstance(OcamlRunner::class.java)
        val merlinErrors = mapOf(
                Pair("type", HighlightSeverity.ERROR),
                Pair("parser", HighlightSeverity.ERROR),
                Pair("env", HighlightSeverity.ERROR),
                Pair("warning", HighlightSeverity.WARNING),
                Pair("unkown", HighlightSeverity.INFORMATION))
    }

    //TODO Add some intelligence here to help decide whether the annotator should run
    override fun collectInformation(@NotNull file: PsiFile): MerlinInfo? {
        val component = file.project.getService(MerlinServiceComponent::class.java)
        return MerlinInfo(file, file.text, component)
    }

    override fun doAnnotate(merlinInfo: MerlinInfo): Results? {
        val ln = LineNumbering(merlinInfo.source)
        val errors = merlinInfo.merlinService.errors(merlinInfo.file)
        return Results(errors, ln)
    }

    override fun apply(file: PsiFile, results: Results, holder: AnnotationHolder) {
        val ln = results.lineNumbering
        val (t, f) = results.errors.partition { it.start == null || it.end == null }
        for (error in f) {
            val range = TextRange(ln.index(error.start!!), ln.index(error.end!!))
            if (!merlinErrors.containsKey(error.type)) {
                LOG.error("Unmapped error %s".format(f))
            }
            val severity = merlinErrors[error.type]?:HighlightSeverity.ERROR
            val message = error.message
            holder.createAnnotation(severity, range, message)
        }
    }

}

data class MerlinInfo(
        val file: PsiFile,
        val source: String,
        val merlinService: MerlinServiceComponent)

data class Results(val errors: List<MerlinError>, val lineNumbering: LineNumbering)