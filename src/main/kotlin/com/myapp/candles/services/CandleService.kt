package com.myapp.candles.services

import com.myapp.candles.dto.CandleDTO
import com.myapp.candles.repositories.CandleRepository
import com.myapp.candles.utils.CandleMapping

import org.springframework.stereotype.Service
import java.util.UUID
import kotlin.NoSuchElementException
import kotlin.collections.ArrayList

@Service
class CandleService (private val candleRepository: CandleRepository) {

    private val candleMapping: CandleMapping = CandleMapping()
    fun findCandle(id: UUID): Any {
        return try {
            candleMapping.entityToDto(candleRepository.findById(id).get())
        } catch (ex: NoSuchElementException) {
            "This candle does not exist."
        }
    }

    fun findAll(): List<CandleDTO> {
        val entities = candleRepository.findAll().toList()
        val dtoList : MutableList<CandleDTO> = ArrayList()

        for(entity in entities) {
            dtoList.add(candleMapping.entityToDto(entity))
        }

        return dtoList
    }

    fun addCandle(candle: CandleDTO) : CandleDTO{
        return candleMapping.entityToDto(candleRepository.save(candleMapping.dtoToEntity(candle)))
    }
}