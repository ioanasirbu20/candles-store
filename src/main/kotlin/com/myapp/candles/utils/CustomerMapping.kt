package com.myapp.candles.utils

import com.myapp.candles.dto.CustomerDTO
import com.myapp.candles.entities.Customer

class CustomerMapping {

    fun dtoToEntity(customerDTO: CustomerDTO) : Customer {
        return Customer(name = customerDTO.name, customerDTO.id)
    }

    fun entityToDto(customer: Customer) : CustomerDTO {
        return CustomerDTO(name = customer.name, id = customer.id)
    }
}