package com.guiguat.reactiveshop.application.repositories

import com.guiguat.reactiveshop.domain.OrderStatus
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface OrderStatusRepository : ReactiveMongoRepository<OrderStatus, String>