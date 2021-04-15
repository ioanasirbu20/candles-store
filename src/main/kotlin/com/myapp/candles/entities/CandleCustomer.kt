package com.myapp.candles.entities

import javax.persistence.GeneratedValue
import javax.persistence.Id

class CandleCustomer(
        @Id @GeneratedValue var id: Long? = null,
        var candleId: Long,
        var customerId: Long
)