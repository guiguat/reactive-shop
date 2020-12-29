package com.guiguat.reactiveshop.application.repositories

import com.guiguat.reactiveshop.domain.Product
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductRepository : MongoRepository<Product, String>