package org.seleznyoviyu.klab.r2jdbc.web.controller

import org.seleznyoviyu.klab.r2jdbc.domain.service.ProductGetByNameService
import org.seleznyoviyu.klab.r2jdbc.web.json.ProductJson
import org.seleznyoviyu.klab.r2jdbc.web.mapper.ProductJsonMapper
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class ProductGetByNameController(
    private val service: ProductGetByNameService,
    private val mapper: ProductJsonMapper
) {
    @GetMapping("/product")
    suspend fun getByName(@RequestParam("name") name: String): ProductJson {
        return mapper.map(
            service.getProductByName(name)
        )
    }
}