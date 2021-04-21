package com.myapp.candles.services

import com.myapp.candles.entities.Customer
import com.myapp.candles.repositories.CustomerRepository

import org.springframework.stereotype.Service
import java.util.*

@Service
class CustomerService(private val customerRepository: CustomerRepository) {

    fun addCustomer(client: Customer) : Customer{
        return customerRepository.save(client)
    }

    fun findAll() : List<Customer> {
        return customerRepository.findAll().toList()
    }

    fun findById(id : UUID) : Optional<Customer> {
        return customerRepository.findById(id)
    }
}