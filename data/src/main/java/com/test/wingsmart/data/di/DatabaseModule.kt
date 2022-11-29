package com.test.wingsmart.data.di

import android.content.Context
import androidx.room.Room
import com.test.wingsmart.data.local.database.AppDatabase
import com.test.wingsmart.data.local.database.dao.ProductDao
import com.test.wingsmart.data.local.database.dao.UserDao
import com.test.wingsmart.data.model.WingsUser
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.withContext
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    companion object {
        const val QUALIFIER_APP_DATABASE = "APP_DATABASE"
    }

    @Singleton
    @Provides
    @Named(QUALIFIER_APP_DATABASE)
    fun provideAppDatabase(@ApplicationContext context: Context): AppDatabase {
        try {
            return Room.databaseBuilder(context, AppDatabase::class.java, "wingsmart_db")
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .createFromAsset("database/user.db")
                .createFromAsset("database/products.db")
                .build()
        } catch (e: Exception) {
            throw e
        }
    }

    @Singleton
    @Provides
    fun provideUserDao(@Named(QUALIFIER_APP_DATABASE) database: AppDatabase): UserDao {
        return database.userDao()
    }

    @Singleton
    @Provides
    fun provideProductDao(@Named(QUALIFIER_APP_DATABASE) database: AppDatabase): ProductDao {
        return database.productDao()
    }
}