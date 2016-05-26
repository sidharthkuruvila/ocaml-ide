package org.ocaml.lang.parser

import com.intellij.lang.ASTNode
import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiParser
import com.intellij.psi.tree.IElementType
import org.ocaml.lang.parser.psi.OcamlNonTerminals
import org.ocaml.merlin.BrowseNode
import org.ocaml.merlin.Merlin
import org.ocaml.merlin.Position
import java.util.regex.Pattern

class MerlinParser(private val filename: String, private val merlin: Merlin) : PsiParser {
    override fun parse(root: IElementType, builder: PsiBuilder): ASTNode {
        val rootMarker = builder.mark()
        val src = builder.originalText
        merlin.drop(filename)
        merlin.tellSource(filename, src)
        val treeList = merlin.dumpBrowse(filename)

        val tree = nodesWithIndex(src, treeList[0])

        fun parseNode(node: NodeWithIndex) {
            val mark = builder.mark()
            for (child in node.children) {
                parseNode(child)
            }
            val p = node.kind.split(Pattern.compile("\\w+"), 1)[0]
            mark.done(OcamlNonTerminals.elementNameMap[p]!!)
        }

        while (!builder.eof()) {
            builder.advanceLexer()
        }
        rootMarker.done(root)
        return builder.treeBuilt;
    }


    private fun nodesWithIndex(source: CharSequence, browseNode: BrowseNode): NodeWithIndex {
        fun nextIndex(curIndex: Int, curPos: Position, nextPos: Position): Int {
            var i = curIndex
            var curLine = curPos.line
            var curCol = curPos.col
            while (i <= source.length) {
                if (nextPos.line == curLine && nextPos.col == curCol) {
                    return i
                }
                if (source[i] == '\n') {
                    curLine += 1
                    curCol = 0
                } else {
                    curCol += 1
                }
                i++
            }
            throw IllegalStateException("The line number ${nextPos.line} and column number ${nextPos.col} are outside the source length ${source.length}")
        }


        var curIndex: Int = 0
        var curPos: Position = Position(1, 0)
        fun _loop(node: BrowseNode): NodeWithIndex {
            val start = node.start
            val startIndex = nextIndex(curIndex, curPos, start)
            curPos = start
            curIndex = startIndex

            val children = node.children.map { _loop(it) }

            val end = node.end
            val endIndex = nextIndex(curIndex, curPos, end)
            return NodeWithIndex(start = startIndex, end = endIndex, kind = node.kind, children = children)
        }
        return _loop(browseNode)
    }

}

data class NodeWithIndex(val start: Int, val end: Int, val kind: String, val children: List<NodeWithIndex>)