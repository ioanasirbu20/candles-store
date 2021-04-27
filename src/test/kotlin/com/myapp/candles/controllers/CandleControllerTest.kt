package com.myapp.candles.controllers

import com.myapp.candles.dto.CandleDTO
import com.myapp.candles.services.CandleService

import com.google.gson.Gson
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import org.junit.jupiter.api.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.MediaType
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.*
import java.util.*

@RunWith(SpringRunner::class)
@WebMvcTest(controllers = [CandleController::class])
class CandleControllerTest(@Autowired val mockMvc: MockMvc) {

    @MockkBean
    private lateinit var mockService: CandleService

    @Test
    fun `When getCandles return all candles` () {
        val expected = mutableListOf(CandleDTO("mint", 5.0), CandleDTO("lemon", 10.99))

        every { mockService.findAll() } returns expected

        mockMvc.perform(get("/candles/").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.[0].scent").value("mint"))
            .andExpect(jsonPath("\$.[0].price").value("5.0"))
            .andExpect(jsonPath("\$.[1].scent").value("lemon"))
            .andExpect(jsonPath("\$.[1].price").value("10.99"))
    }

    @Test
    fun `When getCandles return empty list` () {
        val expected = emptyList<CandleDTO>()

        every { mockService.findAll() } returns expected

        mockMvc.perform(get("/candles/").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().string("[]"))
    }

    @Test
    fun `When getCandle return error message if the candle does not exist` () {
        val expected = "This candle does not exist."

        val uuid : UUID = UUID.randomUUID()

        every { mockService.findCandle(uuid) } returns expected

        mockMvc.perform(get("/candles/$uuid").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(content().string(expected))
    }

    @Test
    fun `When getCandle return the right candle object` () {
        val expected = CandleDTO("lemongrass", 77.12)

        val uuid : UUID = UUID.randomUUID()

        every { mockService.findCandle(uuid) } returns expected

        mockMvc.perform(get("/candles/$uuid").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.scent").value("lemongrass"))
            .andExpect(jsonPath("\$.price").value(77.12))
    }

    @Test
    fun `When addCandle return the newly created candle object`() {
        val candleDTO = CandleDTO("lemongrass", 55.44)

        val gson = Gson()
        every { mockService.addCandle(candleDTO) } returns candleDTO

        mockMvc.perform(post("/candles/").contentType(MediaType.APPLICATION_JSON)
            .content(gson.toJson(candleDTO))
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andExpect(content().contentType(MediaType.APPLICATION_JSON))
            .andExpect(jsonPath("\$.scent").value("lemongrass"))
            .andExpect(jsonPath("\$.price").value(55.44))
    }
}