package com.guiguat.reactiveshop.application.repositories

import com.guiguat.reactiveshop.domain.OrderStatus
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface OrderStatusRepository : CoroutineCrudRepository<OrderStatus, String>