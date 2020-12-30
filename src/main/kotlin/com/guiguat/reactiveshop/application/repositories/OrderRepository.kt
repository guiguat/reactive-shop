package com.guiguat.reactiveshop.application.repositories

import com.guiguat.reactiveshop.domain.Order
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface OrderRepository : CoroutineCrudRepository<Order, String>