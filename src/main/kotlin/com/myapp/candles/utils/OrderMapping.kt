package com.myapp.candles.utils

import com.myapp.candles.dto.OrderDTO
import com.myapp.candles.entities.Order

class OrderMapping { //TODO see if it's needed

    fun dtoToEntity(orderDTO: OrderDTO) : Order {
        return Order(orderDTO.cost, orderDTO.customer, orderDTO.id)
    }
}