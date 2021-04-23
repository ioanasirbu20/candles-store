package com.myapp.candles.controllers

import com.myapp.candles.dto.CandleDTO
import com.myapp.candles.services.CandleService

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/candles")
class CandleController (private val candleService: CandleService) {


    @GetMapping("/")
    fun getCandles() : List<CandleDTO> {
        return candleService.findAll()
    }

    @PostMapping("/")
    fun addCandle(@RequestBody candle : CandleDTO) : CandleDTO {
        return candleService.addCandle(candle)
    }

    @GetMapping("/{id}")
    fun getCandle(@PathVariable id: String) : Any {
        return candleService.findCandle(id)
    }
}