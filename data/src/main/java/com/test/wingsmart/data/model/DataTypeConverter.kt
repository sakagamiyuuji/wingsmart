package com.test.wingsmart.data.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object DataTypeConverter {

    private val gson = Gson()

    @TypeConverter
    @JvmStatic
    fun wingsProductToList(data: String?): List<WingsProduct> {
        var retVal: List<WingsProduct>? = null
        try {
            val listType = object : TypeToken<List<WingsProduct>>() {}.type
            retVal = gson.fromJson<List<WingsProduct>>(data, listType)
        } catch (e: Exception) {
            // Ignore
        }
        return retVal ?: listOf()
    }

    @TypeConverter
    @JvmStatic
    fun wingsProductListToString(objects: List<WingsProduct>?): String {
        return if (!objects.isNullOrEmpty()) gson.toJson(objects) else ""
    }


}