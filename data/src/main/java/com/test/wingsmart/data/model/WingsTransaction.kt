package com.test.wingsmart.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.test.wingsmart.domain.model.Product
import com.test.wingsmart.domain.model.Transaction
import javax.net.ssl.SSLEngineResult.Status

@Entity(tableName = "transactions")
data class WingsTransaction(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int? = null,

    @ColumnInfo(name = "document_code")
    val documentCode: String? = null,

    @ColumnInfo(name = "document_number")
    val documentNumber: String? = null,

    @ColumnInfo(name = "user")
    val user: String? = null,

    @ColumnInfo(name = "total")
    val total: Long? = null,

    @ColumnInfo(name = "date")
    val date: String? = null,

    @ColumnInfo(name = "products")
    val products: List<WingsProduct>? = null,

    @ColumnInfo(name = "is_success")
    val isSuccess: Boolean? = null
): ModelEntity<Transaction> {
    override fun mapToEntity(): Transaction {
        return Transaction(
            id = id,
            documentCode = documentCode,
            documentNumber = documentNumber,
            user = user,
            total = total,
            date = date,
            products = products?.mapToEntityList(),
            isSuccess = isSuccess)
    }
}
