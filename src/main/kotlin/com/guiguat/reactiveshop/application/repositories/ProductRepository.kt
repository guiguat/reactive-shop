package com.guiguat.reactiveshop.application.repositories

import com.guiguat.reactiveshop.domain.Product
import org.springframework.data.mongodb.repository.ReactiveMongoRepository

interface ProductRepository : ReactiveMongoRepository<Product, String>