package kuruvila.merlin

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by sidharthkuruvila on 01/05/16.
 */


class TestMerlin {



    @Test
    fun testTellSource() {
        val m = merlinInstance()
        val resp = m.tellSource("let f x = x;;")
        assertEquals(TellResponse(cursor = Location(line = 1, col = 13), marker = false), resp)
    }

    private fun merlinInstance(): Merlin {
        val p = merlinProcess()
        val om = ObjectMapper()
        om.registerModule(KotlinModule())
        val m = Merlin(om, p)
        return m
    }

    private fun merlinProcess(): Process {
        val pb = ProcessBuilder("ocamlmerlin")
        return pb.start()
    }
}