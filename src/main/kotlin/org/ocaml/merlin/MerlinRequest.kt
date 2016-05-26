package org.ocaml.merlin

import com.fasterxml.jackson.databind.JsonNode

/**
 * Created by sidharthkuruvila on 25/05/16.
 */
data class MerlinRequest(val context: List<String>, val request: JsonNode)