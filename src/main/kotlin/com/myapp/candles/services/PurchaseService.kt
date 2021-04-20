package com.myapp.candles.services

import com.myapp.candles.entities.CandleCustomer
import com.myapp.candles.entities.Order
import com.myapp.candles.repositories.CandleCustomerRepository
import com.myapp.candles.repositories.CandleRepository
import com.myapp.candles.repositories.OrderRepository

import org.springframework.stereotype.Service

@Service
class PurchaseService(
    private val candleCustomerRepository: CandleCustomerRepository,
    private val candleRepository: CandleRepository,
    private val customerRepository: CandleCustomerRepository,
    private val orderRepository: OrderRepository
) {
    fun purchase(customerId: Long, candleIds: List<Long>) : Long? {
        if (checkCustomerExists(customerId)) {

            val id = orderRepository.save(Order(50.00, customerId)).id
            addCandleCustomer(customerId, candleIds)
            return id
        }
        else {
            throw Exception("Customer $customerId does not exist.")
        }
    }

    fun checkCustomerExists(customerId: Long) : Boolean {
        return customerRepository.existsById(customerId)
    }

    fun checkCandlesExist(candleId: Long) : Boolean {
        return candleRepository.existsById(candleId)
    }

    fun addCandleCustomer(customerId: Long, candleIds: List<Long>) {
        for (candleId in candleIds) {
            if (checkCandlesExist(candleId))  candleCustomerRepository.save(CandleCustomer(candleId, customerId))
            else throw Exception("Candle $candleId does not exist.")
        }
    }

}