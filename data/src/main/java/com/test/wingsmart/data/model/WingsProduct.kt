package com.test.wingsmart.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.test.wingsmart.domain.model.Product

@Entity(tableName = "product")
data class WingsProduct(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int? = null,

    @ColumnInfo(name = "product_code")
    val productCode: String? = null,

    @ColumnInfo(name = "product_name")
    val productName: String? = null,

    @ColumnInfo(name = "price")
    val price: Long? = null,

    @ColumnInfo(name = "currency")
    val currency: String? = null,

    @ColumnInfo(name = "discount")
    val discountPercentage: Int? = null,

    @ColumnInfo(name = "dimension")
    val dimension: String? = null,

    @ColumnInfo(name = "unit")
    val unit: String? = null,

    @ColumnInfo(name= "qty")
    val qty: Int? = null
): ModelEntity<Product> {
    override fun mapToEntity(): Product {
        return Product(
            id, productCode, productName, price, currency, discountPercentage, dimension, unit, qty
        )
    }
}
