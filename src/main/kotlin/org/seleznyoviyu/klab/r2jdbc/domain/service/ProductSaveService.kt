package org.seleznyoviyu.klab.r2jdbc.domain.service

import org.seleznyoviyu.klab.r2jdbc.da.entity.ProductEntity
import org.seleznyoviyu.klab.r2jdbc.da.repository.ProductEntityRepository
import org.seleznyoviyu.klab.r2jdbc.domain.model.Product
import org.springframework.core.convert.converter.Converter
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductSaveService(
    private val productRepository: ProductEntityRepository,
    private val converter: Converter<Product, ProductEntity>
) {
    suspend fun save(product: Product): String {
        val entity = converter.convert(product)!!
        if (product.id == null) {
            val id = UUID.randomUUID().toString()
            productRepository.save(
                entity.copy(id = id)
            )
            return id
        }
        productRepository.save(entity)
        return product.id
    }
}