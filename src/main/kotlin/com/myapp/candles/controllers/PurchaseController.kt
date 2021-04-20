package com.myapp.candles.controllers

import com.myapp.candles.services.PurchaseService

import org.springframework.web.bind.annotation.*
import javax.persistence.EntityNotFoundException

@RestController
@RequestMapping("/purchases")
class PurchaseController (
    private val purchaseService: PurchaseService
        ) {

    @PostMapping("/{customerId}/{candleIds}")
    fun purchase(@PathVariable customerId: Long, @PathVariable candleIds: List<Long>) : String? {
        return try {
            purchaseService.purchase(customerId, candleIds).toString()
        } catch (ex: Exception) {
            ex.message
        }
    }
}