package com.myapp.candles.utils

import com.myapp.candles.dto.CandleDTO
import com.myapp.candles.entities.Candle

import java.util.UUID

class CandleMapping {

    fun dtoToEntity(candleDTO: CandleDTO) : Candle{
        return Candle(scent = candleDTO.scent, price = candleDTO.price, id = UUID.fromString(candleDTO.id))
    }

    fun entityToDto(candle: Candle) : CandleDTO {
        return CandleDTO(scent = candle.scent,price = candle.price, id = candle.id.toString())
    }
}