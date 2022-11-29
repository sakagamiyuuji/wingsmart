package com.test.wingsmart.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.test.wingsmart.data.local.database.dao.ProductDao
import com.test.wingsmart.data.local.database.dao.UserDao
import com.test.wingsmart.data.model.DataTypeConverter
import com.test.wingsmart.data.model.WingsProduct
import com.test.wingsmart.data.model.WingsUser

@Database(
    entities = [WingsUser::class, WingsProduct::class],
    version = 1,
    autoMigrations = [],
    exportSchema = true
)
@TypeConverters(DataTypeConverter::class)
abstract class  AppDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun productDao(): ProductDao

}