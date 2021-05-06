package com.myapp.candles.services

import com.myapp.candles.dto.CandleCustomerDTO
import com.myapp.candles.entities.Candle
import com.myapp.candles.entities.Customer
import com.myapp.candles.entities.Order
import com.myapp.candles.repositories.CandleCustomerRepository
import com.myapp.candles.repositories.CandleRepository
import com.myapp.candles.repositories.CustomerRepository
import com.myapp.candles.repositories.OrderRepository
import com.myapp.candles.utils.CandleCustomerMapping

import org.springframework.stereotype.Service
import java.util.*
import kotlin.NoSuchElementException

@Service
class PurchaseService(
    private val candleCustomerRepository: CandleCustomerRepository,
    private val candleRepository: CandleRepository,
    private val customerRepository: CustomerRepository,
    private val orderRepository: OrderRepository
) {

    private val candleCustomerMapping: CandleCustomerMapping = CandleCustomerMapping()

    fun purchase(customerId: UUID, candleIds: List<UUID>): String {
        val customer = checkCustomerExists(customerId)
        val id = orderRepository.save(
            Order(addCandleCustomer(customerId, candleIds), customer)
        ).id

        return id.toString()
    }

    fun checkCustomerExists(customerId: UUID): Customer {
        val customer = customerRepository.findById(customerId)
        if (customer.isPresent)
            return customer.get()
        else throw NoSuchElementException("Customer $customerId does not exist.")
    }

    fun checkCandlesExist(candleId: UUID): Optional<Candle> {
        return candleRepository.findById(candleId)
    }

    fun addCandleCustomer(customerId: UUID, candleIds: List<UUID>): Double {
        var price: Double = 0.0
        for (candleId in candleIds) {
            val candle = checkCandlesExist(candleId)
            if (candle.isPresent) {
                candleCustomerRepository.save(
                    candleCustomerMapping.dtoToEntity(CandleCustomerDTO(candleId, customerId))
                )
                price += candle.get().price
            } else throw Exception("Candle $candleId does not exist.")
        }
        return price
    }
}