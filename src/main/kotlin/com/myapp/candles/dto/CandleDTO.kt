package com.myapp.candles.dto

import java.util.UUID

data class CandleDTO(val scent: String, val price: Double, val id: UUID? = null)