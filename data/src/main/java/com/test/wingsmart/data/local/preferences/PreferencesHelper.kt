package com.test.wingsmart.data.local.preferences

import android.content.Context
import android.content.SharedPreferences
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.ArrayList

class PreferencesHelper(
    @ApplicationContext private val context: Context
): Preferences {

    companion object {
        const val PREF_GENERAL_NAME = "WingsPrefFile"
    }

    private val generalPreferences: SharedPreferences =
        context.getSharedPreferences(PREF_GENERAL_NAME, Context.MODE_PRIVATE)

    fun ArrayList<String>.toJson(): String {
        return Gson().toJson(this)
    }

    fun jsonStringToArrayList(jsonString: String): ArrayList<String> {
        val myType = object : TypeToken<ArrayList<String>>() {}.type
        return if (jsonString.isNotBlank()) {
            Gson().fromJson(jsonString, myType)
        } else ArrayList()
    }

    fun <T> SharedPreferences.put(key: String, input: T) {
        when (input) {
            is Boolean -> {
                this.edit().putBoolean(key, input).apply()
            }
            is Float -> {
                this.edit().putFloat(key, input).apply()
            }
            is Int -> {
                this.edit().putInt(key, input).apply()
            }
            is Long -> {
                this.edit().putLong(key, input).apply()
            }
            is String -> {
                this.edit().putString(key, input).apply()
            }
        }
    }
    override fun clearAllCache() {
        generalPreferences.edit().clear().apply()
    }

}