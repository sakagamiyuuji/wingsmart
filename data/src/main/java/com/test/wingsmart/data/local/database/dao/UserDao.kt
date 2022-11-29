package com.test.wingsmart.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.test.wingsmart.data.model.WingsUser

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUser(user: WingsUser)

    @get:Query("SELECT * FROM user")
    val user: WingsUser

    @Query("DELETE FROM user")
    fun deleteAll()
}