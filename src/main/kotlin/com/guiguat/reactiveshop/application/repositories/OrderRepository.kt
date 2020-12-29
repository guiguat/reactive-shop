package com.guiguat.reactiveshop.application.repositories

import com.guiguat.reactiveshop.domain.Order
import org.springframework.data.mongodb.repository.MongoRepository

interface OrderRepository : MongoRepository<Order, String>