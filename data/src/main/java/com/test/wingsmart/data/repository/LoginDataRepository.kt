package com.test.wingsmart.data.repository

import com.test.wingsmart.data.source.login.LoginLocalDataSource
import com.test.wingsmart.domain.repository.LoginRepository

class LoginDataRepository(
    private val local: LoginLocalDataSource
): LoginRepository {
    override suspend fun login(username: String, password: String): Boolean {
        return local.login(username, password)
    }
}