package com.myapp.candles.services

import com.myapp.candles.entities.Candle
import com.myapp.candles.repositories.CandleRepository

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import java.util.*

class CandleServiceTest {

    private val mockRepository: CandleRepository = Mockito.mock(CandleRepository::class.java)
    private val candleService: CandleService = CandleService(mockRepository)

    @Test
    fun `When findAll return all` () {
        val expected = mutableListOf(Candle("mint"), Candle("lemon"))

        Mockito.`when`(mockRepository.findAll()).thenReturn(expected.asIterable())

        val actual = candleService.findAll();

        assertEquals(expected, actual)
    }

    @Test
    fun `When find by id return the correct object` () {
        val expected = Optional.of(Candle("amber"))

        Mockito.`when`(mockRepository.findById(1)).thenReturn(expected)

        val actual = candleService.findCandle(1)

        assertEquals(expected, actual)
    }
}