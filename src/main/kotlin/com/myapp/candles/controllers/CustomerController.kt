package com.myapp.candles.controllers

import com.myapp.candles.entities.Customer
import com.myapp.candles.services.CustomerService

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/customers")
class CustomerController(private val customerService: CustomerService) {

    @PostMapping("/")
    fun addCustomer(@RequestBody customer: Customer) : Customer {
        return customerService.addCustomer(customer)
    }

    @GetMapping("/")
    fun findCustomers() : List<Customer> {
        return customerService.findAll();
    }

    @GetMapping("/{id}")
    fun findCustomer(@PathVariable id: Long) : Any {
        return try {
            customerService.findById(id).get()
        } catch (ex: NoSuchElementException) {
            "This customer does not exist."
        }
    }
}