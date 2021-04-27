package com.myapp.candles.services

import com.myapp.candles.dto.CandleDTO
import com.myapp.candles.entities.Candle
import com.myapp.candles.repositories.CandleRepository

import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.spyk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.*

class CandleServiceTest {

    @MockK
    private lateinit var mockRepository: CandleRepository
    private lateinit var candleService: CandleService

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        candleService = spyk(CandleService(mockRepository))
    }

    @Test
    fun `When findAll return all` () {

        val expected = mutableListOf(Candle("mint", 4.4), Candle("lemon", 7.2))

        every { mockRepository.findAll() } returns expected

        val actual = candleService.findAll()

        assertEquals(entitiesToDto(expected), actual)
    }

    @Test
    fun `When findAll return empty list` () {

        val expected = emptyList<Candle>()

        every { mockRepository.findAll() } returns expected

        val actual = candleService.findAll()

        assertEquals(entitiesToDto(expected), actual)
    }

    @Test
    fun `When find by id return the correct object if it exists` () {
        val id = UUID.randomUUID()
        val expected = Optional.of(Candle("amber", 5.5, id))

        every { mockRepository.findById(id) } returns expected

        val actual = candleService.findCandle(id)

        assertEquals(entitiesToDto(mutableListOf(expected.get()))[0], actual)
    }

    @Test
    fun `When find by id return an error message` () {
        val id = UUID.randomUUID()

        every { mockRepository.findById(id) } returns Optional.empty()

        val actual = candleService.findCandle(id)

        assertEquals("This candle does not exist.", actual)
    }

    @Test
    fun `When addCandle return the candle object` () { // TODO fix test
        val expected = Candle("amber", 5.5)

        every { mockRepository.save(expected) } returns expected

        val actual = candleService.addCandle(entitiesToDto(mutableListOf(expected))[0])

        assertEquals(entitiesToDto(mutableListOf(expected))[0], actual)
    }

    private fun entitiesToDto(candles: List<Candle>): List<CandleDTO> {
        var result = mutableListOf<CandleDTO>()
        for (candle in candles) {
            result.add(CandleDTO(candle.scent, candle.price, candle.id))
        }

        return result
    }
}