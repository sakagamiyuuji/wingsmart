package com.test.wingsmart.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.test.wingsmart.data.model.WingsProduct
import com.test.wingsmart.data.model.WingsUser
import com.test.wingsmart.domain.model.Product

@Dao
interface ProductDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveProducts(products: List<WingsProduct>)

    @get:Query("SELECT * FROM product")
    val products: List<WingsProduct>

    @Query("DELETE FROM product")
    fun deleteAll()
}