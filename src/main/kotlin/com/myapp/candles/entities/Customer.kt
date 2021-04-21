package com.myapp.candles.entities

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "customer")
class Customer(
        var name: String,

        @Id @GeneratedValue(generator = "system-uuid") @GenericGenerator(name = "syste,-uuid", strategy = "uuid")
        val id: UUID? = null
)