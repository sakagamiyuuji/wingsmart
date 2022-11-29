package com.test.wingsmart.domain.usecase.login

interface LoginUseCase {

    suspend fun login(username: String, password: String): Boolean
}