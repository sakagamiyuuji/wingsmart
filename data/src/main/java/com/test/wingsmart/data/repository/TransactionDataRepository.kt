package com.test.wingsmart.data.repository

import com.test.wingsmart.data.model.WingsProduct
import com.test.wingsmart.data.model.WingsTransaction
import com.test.wingsmart.data.model.mapToEntityList
import com.test.wingsmart.data.source.transaction.TransactionLocalDataSource
import com.test.wingsmart.domain.model.Transaction
import com.test.wingsmart.domain.repository.ProductRepository
import com.test.wingsmart.domain.repository.TransactionRepository

class TransactionDataRepository(
    private val local: TransactionLocalDataSource
): TransactionRepository {

    override suspend fun getPendingTransaction(): Transaction? {
        return local.getPendingTransaction()?.mapToEntity()
    }

    override suspend fun getAllTransaction(): List<Transaction> {
        return local.getAllTransaction().mapToEntityList()
    }

    override suspend fun updatePendingTransaction(transaction: Transaction, isSuccess: Boolean) {
        val listProduct = mutableListOf<WingsProduct>()
        transaction.products?.forEach {
            listProduct.add(
                WingsProduct(
                    id = it.id,
                    productCode = it.productCode,
                    productName = it.productName,
                    price = it.price,
                    currency = it.currency,
                    discountPercentage = it.discountPercentage,
                    dimension = it.dimension,
                    unit = it.unit,
                    qty = it.qty
                )
            )
        }
        local.updatePendingTransaction(WingsTransaction(
            id = transaction.id,
            documentCode = transaction.documentCode,
            documentNumber = transaction.documentNumber,
            user = transaction.user,
            total = transaction.total,
            date = transaction.date,
            products = listProduct,
            isSuccess = transaction.isSuccess,
        ))
    }
}