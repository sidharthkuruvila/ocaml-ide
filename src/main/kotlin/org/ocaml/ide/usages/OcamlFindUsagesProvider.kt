package org.ocaml.ide.usages

import com.intellij.lang.cacheBuilder.SimpleWordsScanner
import com.intellij.lang.cacheBuilder.WordsScanner
import com.intellij.lang.findUsages.FindUsagesProvider
import com.intellij.psi.PsiElement

class OcamlFindUsagesProvider : FindUsagesProvider {
    override fun getWordsScanner(): WordsScanner? {
        return SimpleWordsScanner()
    }

    override fun getNodeText(element: PsiElement, useFullName: Boolean): String {
        return element.text
    }

    override fun getDescriptiveName(element: PsiElement): String {
        return element.text
    }

    override fun getType(element: PsiElement): String {
        return "type"
    }

    override fun getHelpId(psiElement: PsiElement): String? {
        return "help"
    }

    override fun canFindUsagesFor(psiElement: PsiElement): Boolean {
        return true
    }

}