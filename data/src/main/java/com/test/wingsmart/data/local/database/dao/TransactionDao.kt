package com.test.wingsmart.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.test.wingsmart.data.model.WingsProduct
import com.test.wingsmart.data.model.WingsTransaction
import com.test.wingsmart.data.model.WingsUser
import com.test.wingsmart.domain.model.Product
import com.test.wingsmart.domain.model.Transaction

@Dao
interface TransactionDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addTransaction(transaction: WingsTransaction)

    @Update(entity = WingsTransaction::class, onConflict = OnConflictStrategy.REPLACE)
    //@Query("SELECT * FROM transactions where document_code = :transaction.documentCode AND document_number = :documentNumber")
    suspend fun updateTransaction(transaction: WingsTransaction)

    @get:Query("SELECT * FROM transactions")
    val transactions: List<WingsTransaction>

    @Query("DELETE FROM transactions")
    fun deleteAll()
}