package com.myapp.candles.repositories

import com.myapp.candles.entities.Candle

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager
import java.util.*

@DataJpaTest
class CandleRepositoryTest @Autowired constructor(
        val entityManager: TestEntityManager,
        val candleRepository: CandleRepository) {

    @Test
    fun `When findById return the right entity` () {

        val entity = Candle("vanilla", 6.5)
        val id = entityManager.persistAndGetId(entity)
        entityManager.flush()
        val retrievedEntity = candleRepository.findById(UUID.fromString(id.toString()))

        assertEquals(id, retrievedEntity.get().id)
        assertEquals( "vanilla", retrievedEntity.get().scent)
    }

    @Test
    fun `When findAll return all candle entities` () {
        val entityOne = Candle("mint", 4.5)
        val entityTwo = Candle( "lemon", 2.3)
        entityManager.persist(entityOne)
        entityManager.persist(entityTwo)
        entityManager.flush()

        val retrievedEntities = candleRepository.findAll()

        assertEquals(2, retrievedEntities.count())
        assertEquals(1, retrievedEntities.elementAt(0).id)
        assertEquals("mint", retrievedEntities.elementAt(0).scent)
        assertEquals(2, retrievedEntities.elementAt(1).id)
        assertEquals("lemon", retrievedEntities.elementAt(1).scent)
    }
}