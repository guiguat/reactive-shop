package com.guiguat.reactiveshop.controller

import com.guiguat.reactiveshop.application.service.OrderService
import com.guiguat.reactiveshop.application.service.OrderStatusService
import com.guiguat.reactiveshop.domain.OrderReqDTO
import com.guiguat.reactiveshop.domain.OrderResDTO
import com.guiguat.reactiveshop.domain.OrderStatusCode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.ResponseEntity.ok
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController()
@RequestMapping("/order")
class OrderController @Autowired constructor(
    private val service: OrderService,
    private val statusService: OrderStatusService){

    @PostMapping @ResponseStatus(HttpStatus.CREATED)
    fun createOrder(@RequestBody order: OrderReqDTO): Mono<OrderResDTO> = service.create(order)

    @GetMapping("{id}")
    fun findById(@PathVariable id: String): Mono<ResponseEntity<OrderResDTO>> = service.findById(id).map { ok(it) }
        .defaultIfEmpty(ResponseEntity.notFound().build())

    @PutMapping("update/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun updateStatus(
        @PathVariable id: String,
        @RequestParam("status") status: OrderStatusCode) = statusService.update(id, status).map { ok(it) }
            .defaultIfEmpty(ResponseEntity.notFound().build())

    @PutMapping("stream/{id}")
    fun cancelOrder(
        @PathVariable id: String): Nothing = TODO("Not implemented yet")
}