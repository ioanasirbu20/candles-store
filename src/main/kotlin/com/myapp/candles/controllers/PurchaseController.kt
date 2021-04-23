package com.myapp.candles.controllers

import com.myapp.candles.services.PurchaseService

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/purchases")
class PurchaseController (
    private val purchaseService: PurchaseService
        ) {

    @PostMapping("/{customerId}/{candleIds}")
    fun purchase(@PathVariable customerId: String, @PathVariable candleIds: List<String>) : String? {
        return purchaseService.purchase(customerId, candleIds).toString()
    }
}