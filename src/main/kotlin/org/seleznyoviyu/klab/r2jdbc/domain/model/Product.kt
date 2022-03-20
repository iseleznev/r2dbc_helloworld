package org.seleznyoviyu.klab.r2jdbc.domain.model

import java.time.Instant

data class Product(
    val id: String?,
    val name: String,
    val modifyDateTime: Instant?,
    val price: Price,
    val attributeList: List<AttributeValue>
)
