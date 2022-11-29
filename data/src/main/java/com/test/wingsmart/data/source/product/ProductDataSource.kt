package com.test.wingsmart.data.source.product

import com.test.wingsmart.data.model.WingsProduct
import com.test.wingsmart.domain.model.Product

interface ProductDataSource {

    interface Local {
        fun getListProduct(): List<WingsProduct>
    }
}