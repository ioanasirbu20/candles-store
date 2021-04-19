package com.myapp.candles.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "candle")
class Candle(
        var scent: String,
        @Id @GeneratedValue var id: Long? = null)

