package com.myapp.candles.services

import com.myapp.candles.entities.CandleCustomer
import com.myapp.candles.entities.Customer
import com.myapp.candles.entities.Order
import com.myapp.candles.repositories.CandleCustomerRepository
import com.myapp.candles.repositories.CandleRepository
import com.myapp.candles.repositories.CustomerRepository
import com.myapp.candles.repositories.OrderRepository
import com.myapp.candles.utils.CustomerMapping
import com.myapp.candles.utils.OrderMapping

import org.springframework.stereotype.Service
import java.util.UUID
import kotlin.NoSuchElementException

@Service
class PurchaseService(
    private val candleCustomerRepository: CandleCustomerRepository,
    private val candleRepository: CandleRepository,
    private val customerRepository: CustomerRepository,
    private val orderRepository: OrderRepository
) {

    private val orderMapping: OrderMapping = OrderMapping()
    private val customerMapping: CustomerMapping = CustomerMapping()

    fun purchase(customerId: String, candleIds: List<String>): String {
            val id = orderRepository.save(Order(50.00, checkCustomerExists(customerId))).id //TODO remove hard coding
            addCandleCustomer(customerId, candleIds)
            return id.toString()
    }

    fun checkCustomerExists(customerId: String): Customer {
        val customer = customerRepository.findById(UUID.fromString(customerId))
        if (customer.isPresent)
            return customer.get()
        else throw NoSuchElementException("Customer $customerId does not exist.")
    }

    fun checkCandlesExist(candleId: String): Boolean {
        return candleRepository.existsById(UUID.fromString(candleId))
    }

    fun addCandleCustomer(customerId: String, candleIds: List<String>) {
        for (candleId in candleIds) {
            if (checkCandlesExist(candleId)) candleCustomerRepository.save(
                CandleCustomer(
                    UUID.fromString(candleId),
                    UUID.fromString(customerId)
                )
            )
            else throw Exception("Candle $candleId does not exist.")
        }
    }

}