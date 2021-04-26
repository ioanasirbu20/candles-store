package com.myapp.candles.utils

import com.myapp.candles.dto.CandleCustomerDTO
import com.myapp.candles.entities.CandleCustomer

class CandleCustomerMapping {

    private val utilities : Utilities = Utilities()

    fun entityToDto(candleCustomer: CandleCustomer) : CandleCustomerDTO {
        return CandleCustomerDTO(
            utilities.uuidToString(candleCustomer.candleId),
            utilities.uuidToString(candleCustomer.customerId)
        )
    }

    fun dtoToEntity(candleCustomerDTO: CandleCustomerDTO) : CandleCustomer {
        return CandleCustomer(
            utilities.stringToUUID(candleCustomerDTO.candleId),
            utilities.stringToUUID(candleCustomerDTO.customerId)
        )
    }
}