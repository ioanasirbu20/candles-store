package com.myapp.candles.controllers

import com.myapp.candles.services.PurchaseService

import org.springframework.web.bind.annotation.*
import java.util.UUID

@RestController
@RequestMapping("/purchases")
class PurchaseController (
    private val purchaseService: PurchaseService
        ) {

    @PostMapping("/{customerId}/{candleIds}")
    fun purchase(@PathVariable customerId: UUID, @PathVariable candleIds: List<UUID>) : String? {
        return try {
            purchaseService.purchase(customerId, candleIds)
        } catch(ex: NoSuchElementException) {
            ex.message
        }
    }
}