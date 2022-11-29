package com.test.wingsmart.data.source.login

interface LoginDataSource {

    interface Local {
        fun login(username: String, password: String): Boolean
    }
}