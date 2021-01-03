package com.guiguat.reactiveshop.application.service

import com.guiguat.reactiveshop.application.repositories.OrderRepository
import com.guiguat.reactiveshop.application.repositories.OrderStatusRepository
import com.guiguat.reactiveshop.domain.OrderReqDTO
import com.guiguat.reactiveshop.domain.OrderResDTO
import com.guiguat.reactiveshop.domain.OrderStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class OrderService @Autowired constructor(
    private val orderRepo: OrderRepository, private val statusRepo: OrderStatusRepository){
    fun create(orderDTO: OrderReqDTO): Mono<OrderResDTO> =
        orderRepo.save(orderDTO.asOrder()).doOnNext{ statusRepo.save(OrderStatus(it.id!!)) }.
        map { it.asOrderResDTO() }
    fun findById(oid: String): Mono<OrderResDTO> = orderRepo.findById(oid)
        .map { it.asOrderResDTO(statusRepo.findById(oid).get().status) }
}