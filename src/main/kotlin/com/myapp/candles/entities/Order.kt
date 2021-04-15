package com.myapp.candles.entities

import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

class Order(
        @Id @GeneratedValue var id: Long? = null,
        var cost: Double,
        @OneToMany var customerId: Long
)