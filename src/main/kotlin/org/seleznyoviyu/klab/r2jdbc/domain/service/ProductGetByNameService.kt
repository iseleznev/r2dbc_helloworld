package org.seleznyoviyu.klab.r2jdbc.domain.service

import org.seleznyoviyu.klab.r2jdbc.da.entity.ProductEntity
import org.seleznyoviyu.klab.r2jdbc.da.repository.ProductEntityRepository
import org.seleznyoviyu.klab.r2jdbc.domain.model.Product
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Service

@Service
class ProductGetByNameService(
    private val repository: ProductEntityRepository,
    private val converter: Converter<ProductEntity, Product>
) {
    suspend fun getProductByName(name: String): Product {
        val result = repository.findByName(name)
        return result?.let {
            productEntity -> converter.convert(productEntity)!!
        } ?: throw RuntimeException("Product not found with name = '$name'")
    }
}