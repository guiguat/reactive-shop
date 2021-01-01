package com.guiguat.reactiveshop.controller

import com.guiguat.reactiveshop.application.repositories.ProductRepository
import com.guiguat.reactiveshop.domain.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController()
@RequestMapping("/products")
class ProductController @Autowired constructor(private val repo: ProductRepository) {
    @GetMapping fun getAll() = repo.findAll()

    @GetMapping("{id}")
    fun getById(@PathVariable id: String): Mono<ResponseEntity<Product>> = repo.findById(id).map { ok(it) }
        .defaultIfEmpty(ResponseEntity.notFound().build())

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody prod: Product) = repo.save(prod)
}