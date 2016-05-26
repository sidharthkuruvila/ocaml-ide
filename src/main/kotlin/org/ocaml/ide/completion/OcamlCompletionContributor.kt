package org.ocaml.ide.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.application.ApplicationManager
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext
import org.ocaml.ide.components.MerlinServiceComponent
import org.ocaml.util.LineNumbering

/**
 * Created by sidharthkuruvila on 04/05/16.
 */
class OcamlCompletionContributor : CompletionContributor() {

    val merlinService = ApplicationManager.getApplication().getComponent(MerlinServiceComponent::class.java)

    init {

        extend(CompletionType.BASIC, PlatformPatterns.psiElement(),
                object : CompletionProvider<CompletionParameters>() {
                    override fun addCompletions(parameters: CompletionParameters,
                                       context: ProcessingContext,
                                       resultSet: CompletionResultSet) {
                        val ln = LineNumbering(parameters.originalFile.text)
                        val completions = merlinService.completions(parameters.originalFile.virtualFile.canonicalFile!!,
                                findSuitablePrefix(parameters), ln.position(parameters.offset))
                        for(completion in completions) {
                            resultSet.addElement(LookupElementBuilder.create(completion.name).withTypeText(completion.desc));
                        }
                    }
                })
    }

    fun findSuitablePrefix(parameters: CompletionParameters): String {
        val p = parameters.position
        return ""
    }
}