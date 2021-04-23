package com.myapp.candles.controllers

import com.myapp.candles.dto.CustomerDTO
import com.myapp.candles.services.CustomerService

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
class CustomerController(private val customerService: CustomerService) {

    @PostMapping("/")
    fun addCustomer(@RequestBody customer: CustomerDTO) : CustomerDTO {
        return customerService.addCustomer(customer)
    }

    @GetMapping("/")
    fun findCustomers() : List<CustomerDTO> {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    fun findCustomer(@PathVariable id: String) : Any {
        return customerService.findById(id)
    }
}