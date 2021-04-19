package com.myapp.candles.controllers

import com.myapp.candles.entities.Candle
import com.myapp.candles.services.CandleService

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.boot.test.web.client.getForEntity
import org.springframework.http.HttpStatus

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CandleControllerTest {

    @Autowired lateinit var testRestTemplate: TestRestTemplate
    private val mockService: CandleService = Mockito.mock(CandleService::class.java)

    @Test
    fun `When getCandles return all candles` () {
        val expected = mutableListOf(Candle("mint"), Candle("lemon"))

        Mockito.`when`(mockService.findAll()).thenReturn(expected)

        val actual = testRestTemplate.getForEntity<List<Candle>>("/candles/")

        assertEquals(HttpStatus.OK, actual.statusCode)
        assertThat(actual.body).isNotEmpty
    }


}