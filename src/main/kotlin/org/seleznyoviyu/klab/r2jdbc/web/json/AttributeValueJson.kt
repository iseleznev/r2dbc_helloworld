package org.seleznyoviyu.klab.r2jdbc.web.json

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming

@JsonNaming(
    PropertyNamingStrategies.KebabCaseStrategy::class
)
data class AttributeValueJson(
    val code: String,
    val value: String
)
