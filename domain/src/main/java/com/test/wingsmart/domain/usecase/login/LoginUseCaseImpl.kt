package com.test.wingsmart.domain.usecase.login

import com.test.wingsmart.domain.repository.LoginRepository
import javax.inject.Inject

class LoginUseCaseImpl @Inject constructor(
    private val repository: LoginRepository
): LoginUseCase {
    override suspend fun login(username: String, password: String): Boolean {
        return repository.login(username, password)
    }
}