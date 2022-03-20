package org.seleznyoviyu.klab.r2jdbc.web.mapper

import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.seleznyoviyu.klab.r2jdbc.domain.model.Product
import org.seleznyoviyu.klab.r2jdbc.web.json.ProductJson

@Mapper(
    componentModel = "spring",
    injectionStrategy = InjectionStrategy.CONSTRUCTOR
)
interface ProductDomainMapper {
    fun map(source: ProductJson): Product
}