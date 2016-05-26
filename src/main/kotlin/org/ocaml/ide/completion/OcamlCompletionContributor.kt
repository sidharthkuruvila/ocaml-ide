package org.ocaml.ide.completion

import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.openapi.util.Key
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext
import org.ocaml.lang.lexer.OcamlTypes

/**
 * Created by sidharthkuruvila on 04/05/16.
 */
class OcamlCompletionContributor : CompletionContributor() {
    init {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(),
                object : CompletionProvider<CompletionParameters>() {
                    override fun addCompletions(parameters: CompletionParameters,
                                       context: ProcessingContext,
                                       resultSet: CompletionResultSet) {
                        resultSet.addElement(LookupElementBuilder.create("Hello"));
                    }
                })
    }
}