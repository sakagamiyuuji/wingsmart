package com.test.wingsmart.domain.usecase.transaction

import com.test.wingsmart.domain.model.Product
import com.test.wingsmart.domain.model.Transaction

interface TransactionUseCase {
    suspend fun getPendingTransaction(): Transaction?
    suspend fun getAllTransaction(): List<Transaction>
    suspend fun updatePendingTransaction(transaction: Transaction, isSuccess: Boolean = false)
}