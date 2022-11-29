package com.test.wingsmart.data.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase.Callback
import androidx.sqlite.db.SupportSQLiteDatabase
import com.test.wingsmart.data.local.database.AppDatabase
import com.test.wingsmart.data.local.database.dao.ProductDao
import com.test.wingsmart.data.local.database.dao.TransactionDao
import com.test.wingsmart.data.local.database.dao.UserDao
import com.test.wingsmart.data.model.WingsUser
import com.test.wingsmart.data.model.source.UserData
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Named
import javax.inject.Singleton
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.coroutineContext

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
                //.createFromAsset("database/user.db")
                .createFromAsset("database/products.db")
                .build()
        } catch (e: Exception) {
            throw e
        }
    }

    @Singleton
    @Provides
    fun provideUserDao(@Named(QUALIFIER_APP_DATABASE) database: AppDatabase): UserDao {
        CoroutineScope(Dispatchers.IO).launch {
            database.userDao().saveUser(UserData.populateUserData())
        }
        return database.userDao()
    }

    @Singleton
    @Provides
    fun provideProductDao(@Named(QUALIFIER_APP_DATABASE) database: AppDatabase): ProductDao {
        return database.productDao()
    }

    @Singleton
    @Provides
    fun provideTransactionDao(@Named(QUALIFIER_APP_DATABASE) database: AppDatabase): TransactionDao {
        return database.transactionDao()
    }
}