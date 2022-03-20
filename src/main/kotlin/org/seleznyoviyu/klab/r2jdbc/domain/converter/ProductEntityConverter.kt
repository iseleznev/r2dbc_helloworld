package org.seleznyoviyu.klab.r2jdbc.domain.converter

import com.fasterxml.jackson.databind.ObjectMapper
import io.r2dbc.postgresql.codec.Json
import org.seleznyoviyu.klab.r2jdbc.da.entity.ProductEntity
import org.seleznyoviyu.klab.r2jdbc.domain.model.Product
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Component
import java.time.Instant

@Component
class ProductEntityConverter(
    private val objectMapper: ObjectMapper
) : Converter<Product, ProductEntity> {
    override fun convert(source: Product): ProductEntity {
        return ProductEntity(
            id = source.id,
            name = source.name,
            modifyDateTime = Instant.now(),
            priceJson = Json.of(
                objectMapper.writeValueAsString(source.price)
            ),
            attributeListJson = Json.of(
                objectMapper.writeValueAsString(source.attributeList)
            )
        )
    }
}