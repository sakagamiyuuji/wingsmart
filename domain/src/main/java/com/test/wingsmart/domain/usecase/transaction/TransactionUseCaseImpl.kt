package com.test.wingsmart.domain.usecase.transaction

import com.test.wingsmart.domain.model.Transaction
import com.test.wingsmart.domain.repository.LoginRepository
import com.test.wingsmart.domain.repository.TransactionRepository
import javax.inject.Inject

class TransactionUseCaseImpl @Inject constructor(
    private val repository: TransactionRepository
): TransactionUseCase {
    override suspend fun getPendingTransaction(): Transaction? {
        return repository.getPendingTransaction()
    }

    override suspend fun getAllTransaction(): List<Transaction> {
        return repository.getAllTransaction()
    }

    override suspend fun updatePendingTransaction(transaction: Transaction, isSuccess: Boolean) {
        repository.updatePendingTransaction(transaction, isSuccess)
    }

}