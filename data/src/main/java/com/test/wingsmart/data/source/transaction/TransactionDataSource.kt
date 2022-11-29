package com.test.wingsmart.data.source.transaction

import com.test.wingsmart.data.model.WingsProduct
import com.test.wingsmart.data.model.WingsTransaction
import com.test.wingsmart.domain.model.Product

interface TransactionDataSource {

    interface Local {
        suspend fun getPendingTransaction(): WingsTransaction?
        suspend fun updatePendingTransaction(transaction: WingsTransaction)
        //suspend fun updatePendingTransaction(documentCode: String, documentNumber: String, listProduct: List<WingsProduct>) {
    }
}