package com.test.wingsmart.data.source.product

import com.test.wingsmart.data.local.database.dao.ProductDao
import com.test.wingsmart.data.local.database.dao.UserDao
import com.test.wingsmart.data.local.preferences.Preferences
import com.test.wingsmart.data.model.WingsProduct
import com.test.wingsmart.domain.model.Product
import javax.inject.Inject

class ProductLocalDataSource @Inject constructor(
    private val preferences: Preferences,
    private val productDao: ProductDao
) : ProductDataSource.Local {
    override fun getListProduct(): List<WingsProduct> {
        return productDao.products
    }

}