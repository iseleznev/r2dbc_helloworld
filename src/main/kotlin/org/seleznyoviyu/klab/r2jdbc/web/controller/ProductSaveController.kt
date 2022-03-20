package org.seleznyoviyu.klab.r2jdbc.web.controller

import org.seleznyoviyu.klab.r2jdbc.domain.service.ProductSaveService
import org.seleznyoviyu.klab.r2jdbc.web.json.ProductJson
import org.seleznyoviyu.klab.r2jdbc.web.mapper.ProductDomainMapper
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductSaveController(
    private val service: ProductSaveService,
    private val mapper: ProductDomainMapper
) {
    @PutMapping("/product")
    suspend fun saveProduct(@RequestBody request: ProductJson): String {
        return service.save(
            mapper.map(request)
        )
    }
}