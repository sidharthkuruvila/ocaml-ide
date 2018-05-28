package org.ocaml.ide.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.application.ApplicationManager
import com.intellij.openapi.diagnostic.Logger
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext
import org.ocaml.ide.components.MerlinServiceComponent
import org.ocaml.util.LineNumbering
import org.ocaml.util.ReversedSubstringCharSequence

class OcamlCompletionContributor : CompletionContributor() {

    companion object {
        private val LOG = Logger.getInstance(this::class.java)
    }

    val merlinService = ApplicationManager.getApplication().getComponent(MerlinServiceComponent::class.java)

    init {
        LOG.debug("Enabling OcamlCompletionContributor backed by merlin.")
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(),
                object : CompletionProvider<CompletionParameters>() {
                    override fun addCompletions(parameters: CompletionParameters,
                                       context: ProcessingContext,
                                       resultSet: CompletionResultSet) {
                        val ln = LineNumbering(parameters.originalFile.text)
                        LOG.debug("About to fetch completions")
                        val completions = merlinService.completions(parameters.originalFile,
                                findSuitablePrefix(parameters), ln.position(parameters.offset))
                        LOG.debug("Fetch completions $completions")
                        for(completion in completions) {
                            resultSet.addElement(LookupElementBuilder.create(completion.name).withTypeText(completion.desc));
                        }
                    }
                })
    }

    fun findSuitablePrefix(parameters: CompletionParameters): String {
        return findEmacsOcamlAtom(parameters.originalFile.text, parameters.originalPosition!!.textOffset)?:""
    }

    fun findEmacsOcamlAtom(text:String, offset: Int): String? {
        val re = Regex("[a-zA-Z0-9.']*[~?]?")
        val endIndex = re.find(ReversedSubstringCharSequence(text, offset, 0))?.next()?.range?.last

        if (endIndex != null) {
            return text.substring(offset - endIndex, offset + 1)
        }else{
            return null
        }
    }
}