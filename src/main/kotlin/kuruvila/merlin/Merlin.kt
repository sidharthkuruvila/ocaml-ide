package kuruvila.merlin

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.BufferedReader
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * Created by sidharthkuruvila on 30/04/16.
 */
class Merlin(private val objectMapper: ObjectMapper, private val merlinProcess: Process) {
    companion object {
        private val LOG = com.intellij.openapi.diagnostic.Logger.getInstance(Merlin::class.java)
    }

    private val writer = OutputStreamWriter(merlinProcess.outputStream)
    private val reader = BufferedReader(InputStreamReader(merlinProcess.inputStream))

    fun tellSource(source: CharSequence): TellResponse {
        val request = """["tell","source", ${objectMapper.writeValueAsString(source)}]"""
        return makeRequest(request, object: TypeReference<TellResponse>() {})
    }

    fun dumpTokens(): List<Token> {
        val request = """["dump", "tokens"]"""
        return makeRequest(request, object: TypeReference<List<Token>>() {})
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


data class Location(val line: Int, val col: Int)

data class TellResponse(val cursor: Location, val marker: Boolean)

data class Token(val start:Location, val end: Location, val token: String)

