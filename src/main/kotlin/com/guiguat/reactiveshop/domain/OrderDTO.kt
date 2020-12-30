package com.guiguat.reactiveshop.domain

import java.math.BigDecimal
import java.util.*

data class OrderDTO(val total: BigDecimal, val products: String){
    fun toOrder() = Order(null, total, products, Date())
}
