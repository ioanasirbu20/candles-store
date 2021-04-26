package com.myapp.candles.dto

import java.util.UUID

data class CandleDTO(var scent: String, var price: Double, var id: UUID? = null)