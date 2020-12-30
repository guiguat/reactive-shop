package com.guiguat.reactiveshop.application.repositories

import com.guiguat.reactiveshop.domain.Product
import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface ProductRepository : CoroutineCrudRepository<Product, String>