package com.myapp.candles.entities

import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "orders")
class Order(
        var cost: Double,

        @ManyToOne
        @JoinColumn(name ="customer_id")
        var customer: Customer,

        @Id @GeneratedValue(generator = "system-uuid") @GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
        val id: UUID? = null
)