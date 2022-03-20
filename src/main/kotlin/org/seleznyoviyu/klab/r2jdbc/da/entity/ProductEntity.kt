package org.seleznyoviyu.klab.r2jdbc.da.entity

import io.r2dbc.postgresql.codec.Json
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.PersistenceConstructor
import org.springframework.data.annotation.Transient
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant

@Table("product")
data class ProductEntity(

    @Id
    @Column("id")
    private val id: String?,
    @Column("name")
    val name: String,
    @Column("modify_datetime")
    val modifyDateTime: Instant,
    @Column("price_json")
    val priceJson: Json,
    @Column("attribute_list_json")
    val attributeListJson: Json,
    @Transient
    val justCreated: Boolean = id == null
) : Persistable<String> {

    override fun getId() = id

    override fun isNew() = justCreated

    @PersistenceConstructor
    constructor(
        id: String?,
        name: String,
        modifyDateTime: Instant,
        priceJson: Json,
        attributeListJson: Json
    ) : this(
        id = id,
        name = name,
        modifyDateTime = modifyDateTime,
        priceJson = priceJson,
        attributeListJson = attributeListJson,
        justCreated = id == null
    )
}
