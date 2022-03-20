package org.seleznyoviyu.klab.r2jdbc.web.json

import com.fasterxml.jackson.databind.PropertyNamingStrategies
import com.fasterxml.jackson.databind.annotation.JsonNaming
import java.math.BigDecimal

@JsonNaming(
    PropertyNamingStrategies.KebabCaseStrategy::class
)
data class PriceJson(
    val value: BigDecimal,
    val currency: String
)
