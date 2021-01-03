package com.guiguat.reactiveshop.domain

import java.math.BigDecimal
import java.util.*

data class OrderReqDTO(val total: BigDecimal, val products: String){
    fun asOrder() = Order(null, total, products, Date())
}
class OrderResDTO(val id: String, val total: BigDecimal, val products: String, val date: Date, val status: OrderStatusCode)
