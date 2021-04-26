package com.myapp.candles.services

import com.myapp.candles.dto.CandleCustomerDTO
import com.myapp.candles.repositories.CandleCustomerRepository
import com.myapp.candles.utils.CandleCustomerMapping

class CandleCustomerService(private val candleCustomerRepository: CandleCustomerRepository) { //TODO see if it's needed

    private val candleCustomerMapping : CandleCustomerMapping = CandleCustomerMapping()

    fun save(candleCustomerDTO : CandleCustomerDTO) : CandleCustomerDTO {
        return candleCustomerMapping.entityToDto(candleCustomerRepository.save(candleCustomerMapping.dtoToEntity(candleCustomerDTO)))
    }
}