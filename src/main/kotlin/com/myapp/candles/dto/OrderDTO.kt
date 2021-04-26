package com.myapp.candles.dto

import com.myapp.candles.entities.Customer

import java.util.UUID

data class OrderDTO(val cost : Double, val customer : Customer, val id : UUID? = null)
