package com.guiguat.reactiveshop

import com.guiguat.reactiveshop.application.repositories.ProductRepository
import com.guiguat.reactiveshop.domain.Product
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import reactor.core.publisher.Flux
import java.math.BigDecimal

@SpringBootApplication
class ReactiveShopApplication {
	@Bean
	fun init (repository: ProductRepository) = CommandLineRunner{
		Flux.just(
			Product(id=null, name="Açaí", price=BigDecimal("12.99"),
				imgUrl="https://lh3.googleusercontent.com/proxy/vrFNDkVoBNrnkaW_KoZb1e8cJteL4d9d0EUO_P4sh0VP0wRsw-vCkFhTgzqtqvgWXja037PJH7VEiT1bA2bIIQIfFCzC1mevmkRVgp24I9bKwq0hxGmlHBIi4huUxEybCxrOs8wLj4qTfxI7JTt-on8a"),
			Product(id=null, name="Hamburger", price=BigDecimal("24.99"),
				imgUrl="https://exame.com/wp-content/uploads/2020/05/mafe-studio-LV2p9Utbkbw-unsplash-1.jpg"),
			Product(id=null, name="Milk Shake", price=BigDecimal("12.99"),
				imgUrl="https://www.receitasagora.com.br/wp-content/uploads/2020/05/receita-milk-shake-com-biscoito-recheado.jpg"),
			Product(id=null, name="Juice", price=BigDecimal("5.99"),
				imgUrl="https://static1.conquistesuavida.com.br/articles//7/11/49/7/@/30067-preparar-deliciosos-sucos-naturais-de-fr-article_block_media-2.jpg")
		).flatMap { repository.save(it) }.thenMany(repository.findAll()).subscribe{println(it)}
	}
}

fun main(args: Array<String>) {
	runApplication<ReactiveShopApplication>(*args)
}
