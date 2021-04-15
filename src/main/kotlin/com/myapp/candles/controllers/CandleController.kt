package com.myapp.candles.controllers

import com.myapp.candles.entities.Candle
import com.myapp.candles.services.CandleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class CandleController /*(@Autowired private val candleService: CandleService) */{

    @GetMapping("/")
    fun getCandles() : String {
//        return candleService.findAll().toString()
        return "something"
    }
}