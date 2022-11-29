package com.test.wingsmart.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Transaction(
    val id: Int? = null,
    val documentCode: String? = null,
    val documentNumber: String? = null,
    val user: String? = null,
    var total: Long? = null,
    val date: String? = null,
    var products: List<Product>? = null,
    var isSuccess: Boolean? = false
) : Parcelable
