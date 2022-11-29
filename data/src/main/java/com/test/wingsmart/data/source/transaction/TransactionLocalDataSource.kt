package com.test.wingsmart.data.source.transaction

import com.test.wingsmart.data.local.database.dao.ProductDao
import com.test.wingsmart.data.local.database.dao.TransactionDao
import com.test.wingsmart.data.local.database.dao.UserDao
import com.test.wingsmart.data.local.preferences.Preferences
import com.test.wingsmart.data.model.WingsProduct
import com.test.wingsmart.data.model.WingsTransaction
import com.test.wingsmart.domain.model.Product
import com.test.wingsmart.domain.model.Transaction
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

    override suspend fun updatePendingTransaction(transaction: WingsTransaction) {
        transactionDao.updateTransaction(transaction)
    }
}