package com.guiguat.reactiveshop.domain.model

enum class OrderStatusCode (value: Int){
    CANCELED(-1), CONFIRMATION(0), PREPARING(1), DELIVERING(2), COMPLETE(3),
}