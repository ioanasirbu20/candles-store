package com.myapp.candles.utils

import com.myapp.candles.dto.CandleDTO
import com.myapp.candles.entities.Candle

import java.util.UUID

class CandleMapping {

    fun dtoToEntity(candleDTO: CandleDTO) : Candle{
        return Candle(scent = candleDTO.scent, id = UUID.fromString(candleDTO.id))
    }

    fun entityToDto(candle: Candle) : CandleDTO {
        return CandleDTO(scent = candle.scent, id = candle.id.toString())
    }
}