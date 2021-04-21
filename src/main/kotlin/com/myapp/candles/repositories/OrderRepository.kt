package com.myapp.candles.repositories

import com.myapp.candles.entities.Order
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface OrderRepository : CrudRepository<Order, UUID>