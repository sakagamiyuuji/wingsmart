package com.test.wingsmart.domain.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val id: Int? = null,
    val productCode: String? = null,
    val productName: String? = null,
    val price: Long? = null,
    val currency: String? = null,
    val discountPercentage: Int? = null,
    val dimension: String? = null,
    val unit: String? = null
) : Parcelable
