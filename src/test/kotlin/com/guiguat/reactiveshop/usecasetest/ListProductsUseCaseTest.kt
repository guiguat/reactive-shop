package com.guiguat.reactiveshop.usecasetest

import com.guiguat.reactiveshop.application.repositories.ProductRepository
import com.guiguat.reactiveshop.application.usecase.ListProductsUseCase
import com.guiguat.reactiveshop.domain.Product
import com.guiguat.reactiveshop.util.mock
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.mockito.Mockito
import org.mockito.Mockito.times
import reactor.core.publisher.Flux
import java.math.BigDecimal

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ListProductsUseCaseTest {
    private val repository = mock<ProductRepository>()
    @BeforeAll fun setup(){
        val product = Product(id=null, name="Hamburger", price= BigDecimal("24.99"),
            imgUrl="https://exame.com/wp-content/uploads/2020/05/mafe-studio-LV2p9Utbkbw-unsplash-1.jpg")
        Mockito.`when`(repository.findAll()).thenReturn(Flux.just(product))
    }
    @Test fun `test listAll products`(){
        val listProducts = ListProductsUseCase(repository)

        listProducts.execute()
        Mockito.verify(repository, times(1)).findAll()
    }
}
