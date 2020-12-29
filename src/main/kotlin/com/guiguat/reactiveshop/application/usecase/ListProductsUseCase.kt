package com.guiguat.reactiveshop.application.usecase

import com.guiguat.reactiveshop.application.repositories.ProductRepository
import com.guiguat.reactiveshop.domain.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ListProductsUseCase @Autowired constructor(private val repo: ProductRepository) {
    fun execute(): List<Product>{
        return repo.findAll()
    }
}