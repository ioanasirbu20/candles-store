package com.myapp.candles.entities

import javax.persistence.*

@Entity
@Table(name = "orders")
class Order(
        var cost: Double,
        var customerId: Long,
        @Id @GeneratedValue val id: Long? = null
)