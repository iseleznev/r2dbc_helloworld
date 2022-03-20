package org.seleznyoviyu.klab.r2jdbc.domain.model

import com.fasterxml.jackson.annotation.JsonProperty
import java.math.BigDecimal

data class Price(
    val value: BigDecimal,
    val currency: String
)
