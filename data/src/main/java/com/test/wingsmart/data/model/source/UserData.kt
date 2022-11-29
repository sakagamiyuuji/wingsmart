package com.test.wingsmart.data.model.source

import com.test.wingsmart.data.model.WingsUser

object UserData {

    fun populateUserData(): WingsUser {
        return WingsUser(1, "admin", "1234" )
    }
}