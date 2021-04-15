package com.myapp.candles.entities

import javax.persistence.GeneratedValue
import javax.persistence.Id

class Customer(
        @Id @GeneratedValue var id: Long? = null,
        var name: String
)