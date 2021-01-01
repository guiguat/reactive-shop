package com.guiguat.reactiveshop.application.service

import com.guiguat.reactiveshop.application.repositories.OrderRepository
import com.guiguat.reactiveshop.application.repositories.OrderStatusRepository
import com.guiguat.reactiveshop.domain.OrderStatus
import com.guiguat.reactiveshop.domain.OrderStatusCode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrderStatusService @Autowired constructor(
    private val statusRepo: OrderStatusRepository, private val orderRepo: OrderRepository){
    fun update(oid: String, status: OrderStatusCode) = orderRepo.findById(oid)
        .flatMap { statusRepo.save(OrderStatus(oid, status))}
    fun findById(oid: String) = statusRepo.findById(oid)
}
