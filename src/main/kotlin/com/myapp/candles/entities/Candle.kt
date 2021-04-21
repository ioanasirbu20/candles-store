package com.myapp.candles.entities

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "candle")
class Candle(
        var scent: String,

        @Id @GeneratedValue(generator = "system-uuid") @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
        val id: UUID? = null
)

