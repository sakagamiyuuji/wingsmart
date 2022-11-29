package com.test.wingsmart.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.test.wingsmart.domain.model.User

@Entity(tableName = "user")
data class WingsUser(
    @PrimaryKey(autoGenerate = true)
    //@SerializedName("id")
    @ColumnInfo(name = "id")
    val id: Int? = null,

    //@SerializedName("username")
    @ColumnInfo(name = "username")
    val username: String? = null,

    //@SerializedName("password")
    @ColumnInfo(name = "password")
    val password: String? = null
): ModelEntity<User> {
    override fun mapToEntity(): User {
        return User(
           username, password
        )
    }
}
