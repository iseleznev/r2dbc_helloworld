package org.seleznyoviyu.klab.r2jdbc.da.jdbcconverter

import org.springframework.data.convert.ReadingConverter
import org.springframework.stereotype.Component
import java.sql.Timestamp
import java.time.Instant
import java.time.ZoneOffset

@Component
@ReadingConverter
class InstantReadingConverter : JdbcConverter<Timestamp, Instant> {
    override fun convert(source: Timestamp): Instant? {
        return source
            .toLocalDateTime()
            .toInstant(ZoneOffset.UTC)
    }
}