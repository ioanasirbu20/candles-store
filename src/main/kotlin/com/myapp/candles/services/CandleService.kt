package com.myapp.candles.services

import com.myapp.candles.entities.Candle
import com.myapp.candles.repositories.CandleRepository

import org.springframework.stereotype.Service
import java.util.*

@Service
class CandleService (private val candleRepository: CandleRepository) {

    fun findCandle(id: UUID): Optional<Candle> {
        return candleRepository.findById(id)
    }

    fun findAll(): List<Candle> {
        return candleRepository.findAll().toList()
    }

    fun addCandle(candle: Candle) : Candle{
        return candleRepository.save(candle)
    }
}