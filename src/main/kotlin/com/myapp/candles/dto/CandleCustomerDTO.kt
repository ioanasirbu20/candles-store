package com.myapp.candles.dto

import java.util.UUID

data class CandleCustomerDTO(val candleId: UUID, val customerId: UUID, val id: UUID? = null)
