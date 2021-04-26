package com.myapp.candles.utils

import com.myapp.candles.dto.CandleCustomerDTO
import com.myapp.candles.entities.CandleCustomer

class CandleCustomerMapping {

    fun entityToDto(candleCustomer: CandleCustomer) : CandleCustomerDTO {
        return CandleCustomerDTO(
            candleCustomer.candleId,
            candleCustomer.customerId
        )
    }

    fun dtoToEntity(candleCustomerDTO: CandleCustomerDTO) : CandleCustomer {
        return CandleCustomer(
            candleCustomerDTO.candleId,
            candleCustomerDTO.customerId
        )
    }
}