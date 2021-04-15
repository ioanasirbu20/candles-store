package com.myapp.candles.services

import com.myapp.candles.entities.Candle
import com.myapp.candles.repositories.CandleRepository
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

open class CandleService (@Autowired private val candleRepository: CandleRepository) {

    fun findById(id: Long): Optional<Candle> {
        return candleRepository.findById(id)
    }

    fun findAll(): List<Candle> {
        return candleRepository.findAll().toList()
    }
}