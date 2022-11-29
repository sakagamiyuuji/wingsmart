package com.test.wingsmart.data.source.transaction

import com.test.wingsmart.data.local.database.dao.TransactionDao
import com.test.wingsmart.data.local.preferences.Preferences
import com.test.wingsmart.data.model.WingsTransaction
import javax.inject.Inject

class TransactionLocalDataSource @Inject constructor(
    private val preferences: Preferences,
    private val transactionDao: TransactionDao
) : TransactionDataSource.Local {
    override suspend fun getPendingTransaction(): WingsTransaction? {
        val transactions = transactionDao.transactions
        return if (transactions.isNotEmpty()) {
            transactions.firstOrNull { it.isSuccess == false }
        } else null
    }

    override suspend fun getAllTransaction(): List<WingsTransaction> {
        return transactionDao.transactions
    }

    override suspend fun updatePendingTransaction(transaction: WingsTransaction) {
        if (transactionDao.transactions.isEmpty()) {
            transactionDao.addTransaction(transaction)
        } else transactionDao.updateTransaction(transaction)
    }
}