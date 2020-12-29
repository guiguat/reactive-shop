package com.guiguat.reactiveshop

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ReactiveShopApplication

fun main(args: Array<String>) {
	runApplication<ReactiveShopApplication>(*args)
}
