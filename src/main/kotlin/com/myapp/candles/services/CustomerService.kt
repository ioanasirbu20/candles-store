package com.myapp.candles.services

import com.myapp.candles.dto.CustomerDTO
import com.myapp.candles.repositories.CustomerRepository
import com.myapp.candles.utils.CustomerMapping

import org.springframework.stereotype.Service
import java.util.UUID
import kotlin.collections.ArrayList

@Service
class CustomerService(private val customerRepository: CustomerRepository) {

    private val customerMapping = CustomerMapping()

    fun addCustomer(client: CustomerDTO) : CustomerDTO {
        return customerMapping.entityToDto(customerRepository.save(customerMapping.dtoToEntity(client)))
    }

    fun findAll() : List<CustomerDTO> {

        val entities = customerRepository.findAll().toList()
        val dtoList : MutableList<CustomerDTO> = ArrayList()

        for(entity in entities) {
            dtoList.add(customerMapping.entityToDto(entity))
        }

        return dtoList
    }

    fun findById(id : String) : Any {
        return try {
            customerRepository.findById(UUID.fromString(id)).get()
        } catch (ex: NoSuchElementException) {
            "This customer does not exist."
        }
    }
}