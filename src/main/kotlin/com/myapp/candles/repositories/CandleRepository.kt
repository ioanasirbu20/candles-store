package com.myapp.candles.repositories

import com.myapp.candles.entities.Candle
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CandleRepository : CrudRepository<Candle, UUID>