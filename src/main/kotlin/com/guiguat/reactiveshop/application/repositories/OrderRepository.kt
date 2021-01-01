package com.guiguat.reactiveshop.application.repositories

import com.guiguat.reactiveshop.domain.Order
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface OrderRepository : ReactiveMongoRepository<Order, String>