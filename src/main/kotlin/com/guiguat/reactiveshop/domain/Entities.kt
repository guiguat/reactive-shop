package com.guiguat.reactiveshop.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.util.*

@Document data class Product (@Id val id: String? = null, val name: String, val price: BigDecimal)
@Document data class Order(
    @Id val id: String?,
    val total: BigDecimal,
    val products: String,
    val date: Date)
@Document data class OrderStatus (
    @Id val id: String,
    val orderId: String,
    val status: OrderStatusCode = OrderStatusCode.CONFIRMATION
)