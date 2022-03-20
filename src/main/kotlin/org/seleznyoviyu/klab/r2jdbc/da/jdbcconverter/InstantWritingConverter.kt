package org.seleznyoviyu.klab.r2jdbc.da.jdbcconverter

import org.springframework.data.convert.WritingConverter
import org.springframework.stereotype.Component
import java.sql.Timestamp
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

@Component
@WritingConverter
class InstantWritingConverter : JdbcConverter<Instant, Timestamp> {
    override fun convert(source: Instant): Timestamp? {
        return Timestamp.valueOf(
            LocalDateTime.ofInstant(
                source,
                ZoneId.of("UTC")
            )
        )
    }
}