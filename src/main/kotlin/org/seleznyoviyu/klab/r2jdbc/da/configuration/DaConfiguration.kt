package org.seleznyoviyu.klab.r2jdbc.da.configuration

import org.flywaydb.core.Flyway
import org.seleznyoviyu.klab.r2jdbc.da.jdbcconverter.JdbcConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.Environment
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions
import org.springframework.data.r2dbc.dialect.PostgresDialect

@Configuration
class DaConfiguration(
    private val jdbcConverters: List<JdbcConverter<*, *>>,
    private val environment: Environment
) {

    @Bean
    fun customConversions(): R2dbcCustomConversions {
        return R2dbcCustomConversions.of(PostgresDialect.INSTANCE, jdbcConverters);
    }


    @Bean(initMethod = "migrate")
    fun flyway(): Flyway {
        return Flyway(
            Flyway.configure()
                .baselineOnMigrate(true)
                .dataSource(
                    environment.getRequiredProperty("spring.flyway.url"),
                    environment.getRequiredProperty("spring.flyway.user"),
                    environment.getRequiredProperty("spring.flyway.password")
                )
        )
    }
}