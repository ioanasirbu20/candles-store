package com.myapp.candles.services

import com.myapp.candles.entities.CandleCustomer
import com.myapp.candles.entities.Customer
import com.myapp.candles.entities.Order
import com.myapp.candles.repositories.CandleCustomerRepository
import com.myapp.candles.repositories.CandleRepository
import com.myapp.candles.repositories.CustomerRepository
import com.myapp.candles.repositories.OrderRepository

import org.springframework.stereotype.Service
import java.util.*

@Service
class PurchaseService(
    private val candleCustomerRepository: CandleCustomerRepository,
    private val candleRepository: CandleRepository,
    private val customerRepository: CustomerRepository,
    private val orderRepository: OrderRepository
) {
    fun purchase(customerId: UUID, candleIds: List<UUID>) : UUID? {
        val customer = checkCustomerExists(customerId)
        if (customer.isPresent) {

            val id = orderRepository.save(Order(50.00, customer.get())).id
            addCandleCustomer(customerId, candleIds)
            return id
        }
        else {
            throw Exception("Customer $customerId does not exist.")
        }
    }

    fun checkCustomerExists(customerId: UUID) : Optional<Customer> {
        return customerRepository.findById(customerId)
    }

    fun checkCandlesExist(candleId: UUID) : Boolean {
        return candleRepository.existsById(candleId)
    }

    fun addCandleCustomer(customerId: UUID, candleIds: List<UUID>) {
        for (candleId in candleIds) {
            if (checkCandlesExist(candleId))  candleCustomerRepository.save(CandleCustomer(candleId, customerId))
            else throw Exception("Candle $candleId does not exist.")
        }
    }

}