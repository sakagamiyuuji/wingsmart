package com.test.wingsmart.domain.usecase.product

import com.test.wingsmart.domain.model.Product

interface ProductUseCase {

    suspend fun getProductList(): List<Product>
}