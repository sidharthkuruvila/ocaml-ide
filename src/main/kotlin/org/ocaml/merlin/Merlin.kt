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


        private fun merlinInstance(): Merlin {
            val p = merlinProcess()
            val om = ObjectMapper()
            om.registerModule(KotlinModule())
            val m = Merlin(om, p)
            return m
        }

        private fun merlinProcess(): Process {
            val pb = ProcessBuilder("/Users/sidharthkuruvila/Code/ocaml_idea_plugin/merlin/ocamlmerlin")
            return pb.start()
        }

        fun newInstance(): Merlin {
            return merlinInstance()
        }
    }

    private val writer = OutputStreamWriter(merlinProcess.outputStream)
    private val reader = BufferedReader(InputStreamReader(merlinProcess.inputStream))

    fun tellSource(source: CharSequence): TellResponse {
        val request = """["tell","source", ${objectMapper.writeValueAsString(source)}]"""
        return makeRequest(request, object : TypeReference<TellResponse>() {})
    }

    fun dumpTokens(): List<Token> {
        val request = """["dump", "tokens"]"""
        return makeRequest(request, object : TypeReference<List<Token>>() {})
    }

    fun drop() {
        val request = """["drop"]"""
        makeRequest(request, object : TypeReference<TellResponse>() {})
    }

    fun seekExact(position: Position) {
        val request = """["seek", "exact", ${objectMapper.writeValueAsString(position)}]"""
        makeRequest(request, object : TypeReference<TellResponse>() {})
    }

    private fun <T> makeRequest(request: String, c: TypeReference<T>): T {
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


data class Position(val line: Int, val col: Int)

data class TellResponse(val cursor: Position, val marker: Boolean)

data class Token(val start: Position, val end: Position, val token: String)

