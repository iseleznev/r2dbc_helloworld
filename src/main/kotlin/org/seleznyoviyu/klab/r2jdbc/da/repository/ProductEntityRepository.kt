package org.seleznyoviyu.klab.r2jdbc.da.repository

import org.seleznyoviyu.klab.r2jdbc.da.entity.ProductEntity
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import reactor.core.publisher.Mono

interface ProductEntityRepository : CoroutineCrudRepository<ProductEntity, String> {

    @Query(
        """
            SELECT id, name, modify_datetime, price_json, attribute_list_json
            FROM product
            WHERE name = :name
        """
    )
    suspend fun findByName(name: String): ProductEntity?
}