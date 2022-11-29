package com.test.wingsmart.domain.repository

import com.test.wingsmart.domain.model.Transaction

interface TransactionRepository {
    suspend fun getPendingTransaction(): Transaction?
    suspend fun updatePendingTransaction(transaction: Transaction, isSuccess: Boolean = false)
}