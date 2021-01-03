package com.guiguat.reactiveshop.application.repositories

import com.guiguat.reactiveshop.domain.OrderStatus
import org.springframework.data.mongodb.repository.MongoRepository

interface OrderStatusRepository : MongoRepository<OrderStatus, String>