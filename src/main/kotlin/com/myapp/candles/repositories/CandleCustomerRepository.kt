package com.myapp.candles.repositories

import com.myapp.candles.entities.CandleCustomer
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CandleCustomerRepository : CrudRepository<CandleCustomer, UUID>