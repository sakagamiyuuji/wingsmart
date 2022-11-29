package com.test.wingsmart.app.di

import com.test.wingsmart.domain.usecase.login.LoginUseCase
import com.test.wingsmart.domain.usecase.login.LoginUseCaseImpl
import com.test.wingsmart.domain.usecase.product.ProductUseCase
import com.test.wingsmart.domain.usecase.product.ProductUseCaseImpl
import com.test.wingsmart.domain.usecase.transaction.TransactionUseCase
import com.test.wingsmart.domain.usecase.transaction.TransactionUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {

    @Binds
    abstract fun bindLoginUseCase(useCase: LoginUseCaseImpl): LoginUseCase

    @Binds
    abstract fun bindProductUseCase(useCase: ProductUseCaseImpl): ProductUseCase

    @Binds
    abstract fun bindTransactionUseCase(useCase: TransactionUseCaseImpl): TransactionUseCase

}