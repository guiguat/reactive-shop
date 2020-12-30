package com.guiguat.reactiveshop.application.usecase.order

import com.guiguat.reactiveshop.application.repositories.OrderStatusRepository
import com.guiguat.reactiveshop.domain.OrderStatus
import com.guiguat.reactiveshop.domain.OrderStatusCode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CancelOrderUseCase @Autowired constructor(private val repository: OrderStatusRepository){
    suspend fun execute(oid: String): OrderStatus? {
        val prev = repository.findByOrderId(oid)
        return prev?.let {
            return repository.save(OrderStatus(prev.id, oid, OrderStatusCode.CANCELED))
        }
   }
}