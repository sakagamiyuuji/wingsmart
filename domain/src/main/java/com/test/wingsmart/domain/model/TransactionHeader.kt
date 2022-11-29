package com.test.wingsmart.domain.model

data class TransactionHeader(
    val id: Int? = null,
    val documentCode: String? = null,
    val documentNumber: String? = null,
    val user: String? = null,
    val total: Long? = null,
    val date: String? = null
)
