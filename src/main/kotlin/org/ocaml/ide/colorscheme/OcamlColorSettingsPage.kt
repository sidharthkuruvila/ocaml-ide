package org.ocaml.ide.colorscheme

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import org.ocaml.ide.highlighter.OcamlSyntaxHighlighter
import org.ocaml.lang.OcamlIcons
import javax.swing.Icon

/**
 * Created by sidharthkuruvila on 04/05/16.
 */
class OcamlColorSettingsPage : ColorSettingsPage {
    override fun getIcon(): Icon? {
        return OcamlIcons.MODULE_ICON_FILE
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey>? {
        return null
    }

    companion object {
        val DESCRIPTORS = arrayOf(
                AttributesDescriptor("Brace", OcamlSyntaxHighlighter.BRACE),
                AttributesDescriptor("Bracket", OcamlSyntaxHighlighter.BRACKET),
                AttributesDescriptor("Paren", OcamlSyntaxHighlighter.PAREN),
                AttributesDescriptor("Number", OcamlSyntaxHighlighter.NUMBER),
                AttributesDescriptor("Uppercase Identifier", OcamlSyntaxHighlighter.UIDENTIFIER),
                AttributesDescriptor("Lowercase Identifier", OcamlSyntaxHighlighter.IDENTIFIER),
                AttributesDescriptor("Keyword", OcamlSyntaxHighlighter.KEYWORD),
                AttributesDescriptor("String", OcamlSyntaxHighlighter.STRING),
                AttributesDescriptor("Comment", OcamlSyntaxHighlighter.COMMENT),
                AttributesDescriptor("Operator", OcamlSyntaxHighlighter.OPERATOR)
        )
    }

    override fun getHighlighter(): SyntaxHighlighter {
        return OcamlSyntaxHighlighter();
    }

    override fun getDemoText(): String {
        return """
        (* Ocaml works *)
        open Str
        let x = 4 + 3
        let y = 13
        let a = [| 1; 3;|]
        let b = (4, 5)
        """;
    }


    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return DESCRIPTORS;
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return ColorDescriptor.EMPTY_ARRAY;
    }

    override fun getDisplayName(): String {
        return "Ocaml";
    }

}