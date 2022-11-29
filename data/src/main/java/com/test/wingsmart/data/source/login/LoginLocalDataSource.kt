package com.test.wingsmart.data.source.login

import com.test.wingsmart.data.local.database.dao.UserDao
import com.test.wingsmart.data.local.preferences.Preferences
import javax.inject.Inject

class LoginLocalDataSource @Inject constructor(
    private val preferences: Preferences,
    private val userDao: UserDao
) : LoginDataSource.Local {
    override fun login(username: String, password: String): Boolean {
        val user = userDao.user
        return username.equals(user.username, true) && password == user.password
    }
}