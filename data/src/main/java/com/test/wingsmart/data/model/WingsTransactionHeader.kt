package com.test.wingsmart.data.model

import com.google.gson.annotations.SerializedName
import com.test.wingsmart.domain.model.TransactionHeader

data class WingsTransactionHeader(
    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("document_code")
    val documentCode: String? = null,

    @SerializedName("document_number")
    val documentNumber: String? = null,

    @SerializedName("user")
    val user: String? = null,

    @SerializedName("total")
    val total: Long? = null,

    @SerializedName("date")
    val date: String? = null
): ModelEntity<TransactionHeader> {
    override fun mapToEntity(): TransactionHeader {
        return TransactionHeader(id, documentCode, documentNumber, user, total, date)
    }
}
