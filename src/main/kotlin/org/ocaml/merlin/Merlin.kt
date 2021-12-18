package org.ocaml.merlin

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.intellij.openapi.diagnostic.Logger
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * Created by sidharthkuruvila on 30/04/16.
 */
class Merlin(private val objectMapper: ObjectMapper, private val merlinProcess: Process) {

    companion object {
        private val LOG = Logger.getInstance(Merlin::class.java)

        val opamCommand = OpamCommand()

        private fun merlinInstance(): Merlin {
            val p = merlinProcess()
            val om = ObjectMapper()
            om.registerModule(KotlinModule())
            val m = Merlin(om, p)
            return m
        }

        private fun merlinProcess(): Process {
            val pb = opamCommand.processBuilder("ocamlmerlin")
            return pb.start()
        }

        fun newInstance(): Merlin {
            return merlinInstance()
        }
    }

    private val writer = OutputStreamWriter(merlinProcess.outputStream)
    private val reader = BufferedReader(InputStreamReader(merlinProcess.inputStream))

    fun tellSource(filename: String, source: CharSequence): Boolean {
        val request = """["tell", "start", "end", ${objectMapper.writeValueAsString(source)}]"""
        return makeRequest(filename, request, object : TypeReference<Boolean>() {})
    }


    fun errors(filename: String): List<MerlinError> {
        val request = """["errors"]"""
        return makeRequest(filename, request, object : TypeReference<List<MerlinError>>() {})
    }

    fun complete(filename: String, prefix: String, position: Position): Completions {
        val request = """["expand", "prefix", ${objectMapper.writeValueAsString(prefix)}, "at", ${objectMapper.writeValueAsString(position)}]"""
        return makeRequest(filename, request, object : TypeReference<Completions>() {})
    }

    fun locate(filename: String, position: Position): LocateResponse {
        val request = """["locate", null, "ml", "at", ${objectMapper.writeValueAsString(position)}]"""
        val node = makeRequest(filename, request, object : TypeReference<JsonNode>() {})
        println("Locate response: $node")
        if(node.isTextual) {
            if(node.textValue() == "Already at definition point") {
                return LocatedAtPosition
            } else {
                return LocateFailed(node.textValue())
            }
        } else {
            if(node.get("file") == null) {
                return objectMapper.treeToValue(node, LocatedInCurrentFile::class.java)
            } else {
                return objectMapper.treeToValue(node, Located::class.java)
            }
        }
    }
//    TODO Not working on merlin, find an alternative.
//    fun dumpTokens(filename: String): List<Token> {
//        val request = """["dump", "tokens"]"""
//        return makeRequest(filename, request, object : TypeReference<List<Token>>() {})
//    }

    fun dumpBrowse(filename: String): List<BrowseNode> {
        val request = """["dump", "browse"]"""
        return makeRequest(filename, request, object : TypeReference<List<BrowseNode>>() {})
    }

    fun dumpBrowse2(filename: String): JsonNode {
        val request = """["dump", "browse"]"""
        return makeRequest(filename, request, object : TypeReference<JsonNode>() {})
    }


    private fun <T> makeRequest(filename: String, query: String, c: TypeReference<T>): T {
        val request = """{"context": ["auto", ${objectMapper.writeValueAsString(filename)}],
            "query": $query
        }"""
        writer.write(request)
        writer.write("\n")
        writer.flush()

        val s = reader.readLine()
        val response = extractResponse(objectMapper.readTree(s))
        return objectMapper.convertValue(response, c);
    }

    private fun extractResponse(t: JsonNode): JsonNode {
        val responseType = t.get(0).textValue()
        when (responseType) {
            "return" -> return t.get(1)
            else -> {
                LOG.error("Request failed with ${t.get(0).asText()} response ${t.get(1).toString()}")
                throw RuntimeException(t.get(1).toString())
            }
        }
    }

}

data class MerlinError(val start: Position?, val end: Position?, val valid: Boolean,
                       val message: String, val type: String, val sub: List<JsonNode>)

data class Position(val line: Int, val col: Int)

data class TellResponse(val cursor: Position, val marker: Boolean)

data class Token(val start: Position, val end: Position, val token: String)

data class BrowseNode(val start: Position, val end: Position, val ghost: Boolean,
                      val attrs: List<String>, val kind: String, val children: List<BrowseNode>)


data class Completions(val entries: List<CompletionEntry>, val context: CompletionContext?)

data class CompletionEntry(val name: String, val kind: String, val desc: String, val info: String, val deprecated: Boolean)


object CompletionContext

interface LocateResponse

object LocatedAtPosition : LocateResponse
data class LocateFailed(val msg: String) : LocateResponse
data class LocatedInCurrentFile(val pos: Position) : LocateResponse
data class Located(val file: String, val pos: Position): LocateResponse
