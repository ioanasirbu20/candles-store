package com.myapp.candles.controllers

import com.myapp.candles.entities.Candle
import com.myapp.candles.services.CandleService

import org.springframework.web.bind.annotation.*
import java.util.*
import kotlin.NoSuchElementException

@RestController
@RequestMapping("/candles")
class CandleController (private val candleService: CandleService) {


    @GetMapping("/")
    fun getCandles() : List<Candle> {
        return candleService.findAll()
    }

    @PostMapping("/")
    fun addCandle(@RequestBody candle : Candle) : Candle {
        return candleService.addCandle(candle)
    }

    @GetMapping("/{id}")
    fun getCandle(@PathVariable id: UUID) : Any {
        return try {
            candleService.findCandle(id).get()
        } catch (ex: NoSuchElementException) {
            "This candle does not exist."
        }
    }
}