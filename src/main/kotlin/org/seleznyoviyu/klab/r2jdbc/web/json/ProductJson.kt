package org.seleznyoviyu.klab.r2jdbc.web.json

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.time.Instant

@JsonNaming(
    PropertyNamingStrategies.KebabCaseStrategy::class
)
data class ProductJson(
    val id: String?,
    val name: String,
    val modifyDateTime: Instant?,
    val price: PriceJson,
    val attributeList: List<AttributeValueJson>
)
