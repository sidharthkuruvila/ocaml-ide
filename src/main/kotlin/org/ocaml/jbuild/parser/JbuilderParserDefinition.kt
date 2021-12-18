package org.ocaml.jbuild.parser

import com.intellij.lang.ASTNode
import com.intellij.lang.LanguageUtil
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import org.ocaml.jbuild.parser.psi.JbuildCompositeElementTypes
import org.ocaml.jbuild.JbuilderLanguage
import org.ocaml.sexp.lexer.SexpLexer
import org.ocaml.sexp.lexer.SexpTypes

/**
 * Created by sidharthkuruvila on 07/05/16.
 */

class JbuilderParserDefinition : ParserDefinition {

    companion object {
        val FILE = IFileElementType(JbuilderLanguage)
    }

    override fun createParser(project: Project?): PsiParser {
        return JbuildParser()
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return JbuilderPsiFileRoot(viewProvider)
    }

    override fun spaceExistanceTypeBetweenTokens(left: ASTNode, right: ASTNode): ParserDefinition.SpaceRequirements {
        return LanguageUtil.canStickTokensTogetherByLexer(left, right, SexpLexer())
        //return ParserDefinition.SpaceRequirements.MAY;
    }

    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.create(SexpTypes.ATOM)
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    override fun createLexer(project: Project?): Lexer {
        return SexpLexer()
    }

    override fun createElement(node: ASTNode): PsiElement {
        return JbuildCompositeElementTypes.Factory.createElement(node)
    }

    override fun getCommentTokens(): TokenSet {
        return TokenSet.create(SexpTypes.COMMENT)
    }

    override fun getWhitespaceTokens(): TokenSet {
        return TokenSet.create(TokenType.WHITE_SPACE)
    }

}