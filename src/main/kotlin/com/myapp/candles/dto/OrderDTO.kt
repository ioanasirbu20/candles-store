package com.myapp.candles.dto

import com.myapp.candles.entities.Customer

data class OrderDTO(val cost : Double, val customer : Customer, val id : String? = null)
