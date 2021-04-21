package com.myapp.candles.controllers

import com.myapp.candles.services.PurchaseService

import org.springframework.web.bind.annotation.*
import java.util.*
import javax.persistence.EntityNotFoundException

@RestController
@RequestMapping("/purchases")
class PurchaseController (
    private val purchaseService: PurchaseService
        ) {

    @PostMapping("/{customerId}/{candleIds}")
    fun purchase(@PathVariable customerId: UUID, @PathVariable candleIds: List<UUID>) : String? {
        return try {
            purchaseService.purchase(customerId, candleIds).toString()
        } catch (ex: Exception) {
            ex.message
        }
    }
}