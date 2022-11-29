package com.test.wingsmart.domain.usecase.product

import com.test.wingsmart.domain.model.Product
import com.test.wingsmart.domain.repository.LoginRepository
import com.test.wingsmart.domain.repository.ProductRepository
import javax.inject.Inject

class ProductUseCaseImpl @Inject constructor(
    private val repository: ProductRepository
): ProductUseCase {
    override suspend fun getProductList(): List<Product> {
        return repository.getProductList()
    }
}