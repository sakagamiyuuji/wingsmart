package com.test.wingsmart.data.model

interface ModelEntity<T> {
    fun mapToEntity(): T
}

fun <T> List<ModelEntity<T>>.mapToEntityList(): List<T> {
    val list = mutableListOf<T>()
    this.forEach {
        list.add(it.mapToEntity())
    }
    return list
}