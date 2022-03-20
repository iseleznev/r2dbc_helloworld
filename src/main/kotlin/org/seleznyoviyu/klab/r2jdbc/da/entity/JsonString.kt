package org.seleznyoviyu.klab.r2jdbc.da.entity

import com.fasterxml.jackson.databind.ObjectMapper

data class JsonString(
    val value: String
) {

    companion object {
        fun <T> jsonString(source: T, objectMapper: ObjectMapper): JsonString {
            return JsonString(
                objectMapper.writeValueAsString(source)
            )
        }
    }
}
