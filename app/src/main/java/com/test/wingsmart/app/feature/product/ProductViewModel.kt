package com.test.wingsmart.app.feature.product

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.wingsmart.app.feature.transaction.TransactionActivity
import com.test.wingsmart.domain.model.Product
import com.test.wingsmart.domain.model.Transaction
import com.test.wingsmart.domain.usecase.login.LoginUseCase
import com.test.wingsmart.domain.usecase.product.ProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val productUseCase: ProductUseCase
) : ViewModel() {
    val productListLiveData: MutableLiveData<List<Product>?> = MutableLiveData()
    var currentActiveTransaction = MutableLiveData<Transaction?>()

    fun getProductData() {
        viewModelScope.launch {
            val data = productUseCase.getProductList()
            productListLiveData.value = data
        }
    }
}