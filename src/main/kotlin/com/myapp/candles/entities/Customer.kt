package com.myapp.candles.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "customer")
class Customer(
        var name: String,
        @Id @GeneratedValue val id: Long? = null,
)