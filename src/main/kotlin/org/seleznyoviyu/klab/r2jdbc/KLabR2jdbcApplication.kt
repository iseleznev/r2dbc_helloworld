package org.seleznyoviyu.klab.r2jdbc

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.annotation.Version

@SpringBootApplication
class KLabR2jdbcApplication

@Version
fun main(args: Array<String>) {
    runApplication<KLabR2jdbcApplication>(*args)
}