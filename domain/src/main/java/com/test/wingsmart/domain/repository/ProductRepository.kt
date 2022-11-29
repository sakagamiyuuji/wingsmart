package com.test.wingsmart.domain.repository

import com.test.wingsmart.domain.model.Product

interface ProductRepository {
    suspend fun getProductList(): List<Product>
}