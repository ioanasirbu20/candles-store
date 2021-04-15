package com.myapp.candles.repositories

import com.myapp.candles.dto.CandleDTO
import com.myapp.candles.entities.Candle
import org.springframework.data.repository.CrudRepository

interface CandleRepository : CrudRepository<Candle, Long> {
}