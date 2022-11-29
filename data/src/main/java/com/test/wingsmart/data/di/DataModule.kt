package com.test.wingsmart.data.di

import android.content.Context
import com.test.wingsmart.data.local.preferences.Preferences
import com.test.wingsmart.data.local.preferences.PreferencesHelper
import com.test.wingsmart.data.repository.LoginDataRepository
import com.test.wingsmart.data.repository.ProductDataRepository
import com.test.wingsmart.data.source.login.LoginLocalDataSource
import com.test.wingsmart.data.source.product.ProductDataSource
import com.test.wingsmart.data.source.product.ProductLocalDataSource
import com.test.wingsmart.domain.repository.LoginRepository
import com.test.wingsmart.domain.repository.ProductRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Singleton
    @Provides
    fun providePreferencesHelper(@ApplicationContext context: Context): Preferences {
        return PreferencesHelper(context)
    }

    @Provides
    @Singleton
    fun provideLoginRepository(
        localDataSource: LoginLocalDataSource,
    ): LoginRepository = LoginDataRepository(localDataSource)

    @Provides
    @Singleton
    fun provideProductRepository(
        productLocalDataSource: ProductLocalDataSource
    ): ProductRepository = ProductDataRepository(productLocalDataSource)


}