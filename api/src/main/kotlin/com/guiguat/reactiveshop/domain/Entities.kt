package com.guiguat.reactiveshop.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.math.BigDecimal
import java.util.*

@Document data class Product (@Id val id: String?, val imgUrl: String, val name: String, val price: BigDecimal)
@Document data class Order(
    @Id val id: String?,
    val total: BigDecimal,
    val products: String,
    val date: Date) {
    fun asOrderResDTO(status: OrderStatusCode = OrderStatusCode.CONFIRMATION) =
        OrderResDTO(this.id!!, this.total, this.products, this.date,  status)
}
@Document data class OrderStatus(
    @Id @JsonIgnore val orderId: String,
    val status: OrderStatusCode = OrderStatusCode.CONFIRMATION
)