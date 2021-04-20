package com.myapp.candles.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "candle_customer")
class CandleCustomer(
        var candleId: Long,
        var customerId: Long,
        @Id @GeneratedValue val id: Long? = null
)