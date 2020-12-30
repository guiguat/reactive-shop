package com.guiguat.reactiveshop.application.usecase.products

import com.guiguat.reactiveshop.application.repositories.ProductRepository
import com.guiguat.reactiveshop.domain.Product
import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class ListProductsUseCase @Autowired constructor(private val repository: ProductRepository){
    fun execute(): Flow<Product> = repository.findAll()
}