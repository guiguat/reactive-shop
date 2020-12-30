package com.guiguat.reactiveshop.application.usecase.order

import com.guiguat.reactiveshop.application.repositories.OrderRepository
import com.guiguat.reactiveshop.domain.OrderDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CreateOrderUseCase @Autowired constructor(private val orderRepository: OrderRepository){
    suspend fun execute(orderDTO: OrderDTO) = orderRepository.save(orderDTO.toOrder())
}