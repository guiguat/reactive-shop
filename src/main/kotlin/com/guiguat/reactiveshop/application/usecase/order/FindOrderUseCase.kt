package com.guiguat.reactiveshop.application.usecase.order

import com.guiguat.reactiveshop.application.repositories.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FindOrderUseCase @Autowired constructor(private val orderRepository: OrderRepository){
    suspend fun execute(oid: String) = orderRepository.findById(oid)
}