package com.test.wingsmart.data.source.transaction

import com.test.wingsmart.data.model.WingsTransaction

interface TransactionDataSource {

    interface Local {
        suspend fun getPendingTransaction(): WingsTransaction?
        suspend fun getAllTransaction(): List<WingsTransaction>
        suspend fun updatePendingTransaction(transaction: WingsTransaction)
        //suspend fun updatePendingTransaction(documentCode: String, documentNumber: String, listProduct: List<WingsProduct>) {
    }
}