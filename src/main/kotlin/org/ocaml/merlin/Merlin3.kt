package org.ocaml.merlin

import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.JsonNode
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import java.io.OutputStreamWriter

data class Timing(val clock: Long, val cpu: Long, val query: Long, val pp: Long, val reader: Long, val ppx: Long, val typer: Long, val error: Long)
data class ResponsePayload<T>(@JsonProperty("class") val klass: String, val value: T, val notifications: List<String>, val timing: Timing)

class Merlin3(private val mode: String) {
    companion object {
        val opamCommand = OpamCommand()
        val objectMapper = ObjectMapper()
        val typeFactory = objectMapper.typeFactory
        init {
            val kotlinModule = KotlinModule.Builder().build()
            objectMapper.registerModule(kotlinModule)
        }
        val merlin = Merlin3("server")
        fun getInstance(): Merlin3 { return merlin }
    }

    private fun <T>makeRequest(command: String, filename: String, contents: String, typeReference: TypeReference<T>, vararg parameters: String): T {
        val merlinProcess = opamCommand.processBuilder("ocamlmerlin", mode, command, "-filename", filename, *parameters).start()
        val writer = OutputStreamWriter(merlinProcess.outputStream)
        writer.write(contents)
        writer.close()
        val responseJson = objectMapper.readTree(merlinProcess.inputStream)
        val javaType = typeFactory.constructType(typeReference)
        val responseJavaType = typeFactory.constructParametricType(ResponsePayload::class.java, javaType)

        val response: ResponsePayload<T> = objectMapper.convertValue(responseJson, responseJavaType)
        merlinProcess.waitFor()
        if(response.klass == "return") {
            return response.value
        } else {
            throw RuntimeException(response.toString())
        }
    }


    fun errors(filename: String, contents: String): List<MerlinError> {
        return makeRequest("errors", filename, contents, object: TypeReference<List<MerlinError>>() {})
    }

    fun complete(filename: String, contents: String, prefix: String, position: Position): Completions {
        return makeRequest("expand-prefix", filename, contents, object : TypeReference<Completions>() {},
                "-prefix", prefix,
                "-position", positionString(position),
                "-types", "true"

        )
    }

    fun locate(filename: String, contents: String, position: Position): LocateResponse {
        val node = makeRequest("locate", filename, contents, object : TypeReference<JsonNode>() {},
                "-position", positionString(position),
                "-look-for", "implementation"
                )
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

    fun positionString(position: Position): String = "${position.line}:${position.col}"

}

data class MerlinError(val start: Position?, val end: Position?, val valid: Boolean,
                       val message: String, val type: String, val sub: List<JsonNode>)

data class Position(val line: Int, val col: Int)

data class Completions(val entries: List<CompletionEntry>, val context: CompletionContext?)

data class CompletionEntry(val name: String, val kind: String, val desc: String, val info: String, val deprecated: Boolean)


object CompletionContext

interface LocateResponse

object LocatedAtPosition : LocateResponse
data class LocateFailed(val msg: String) : LocateResponse
data class LocatedInCurrentFile(val pos: Position) : LocateResponse
data class Located(val file: String, val pos: Position): LocateResponse