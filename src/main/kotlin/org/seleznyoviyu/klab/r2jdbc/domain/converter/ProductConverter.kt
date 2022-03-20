package org.seleznyoviyu.klab.r2jdbc.domain.converter

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.seleznyoviyu.klab.r2jdbc.da.entity.ProductEntity
import org.seleznyoviyu.klab.r2jdbc.domain.model.Product
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component

@Component
class ProductConverter(
    private val objectMapper: ObjectMapper
) : Converter<ProductEntity, Product> {
    override fun convert(source: ProductEntity): Product {
        return Product(
            id = source.id,
            name = source.name,
            modifyDateTime = source.modifyDateTime,
            price = objectMapper.readValue(
                source.priceJson.asString()
            ),
            attributeList = objectMapper.readValue(
                source.attributeListJson.asString()
            )
        )
    }
}