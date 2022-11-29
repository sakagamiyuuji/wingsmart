package com.test.wingsmart.data.repository

import com.test.wingsmart.data.model.mapToEntityList
import com.test.wingsmart.data.source.login.LoginLocalDataSource
import com.test.wingsmart.data.source.product.ProductLocalDataSource
import com.test.wingsmart.domain.model.Product
import com.test.wingsmart.domain.repository.LoginRepository
import com.test.wingsmart.domain.repository.ProductRepository

class ProductDataRepository(
    private val local: ProductLocalDataSource
): ProductRepository {
    override suspend fun getProductList(): List<Product> {
        return local.getListProduct().mapToEntityList()
    }
}