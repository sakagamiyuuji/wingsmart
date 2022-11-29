package com.test.wingsmart.app.feature.transaction

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.wingsmart.domain.model.Transaction
import com.test.wingsmart.domain.usecase.transaction.TransactionUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class TransactionViewModel @Inject constructor(
    private val useCase: TransactionUseCase
) : ViewModel() {

    val pendingTransactionLiveData = MutableLiveData<Transaction?>()

    fun getPendingTransaction() = viewModelScope.launch {
        val data = useCase.getPendingTransaction()
        pendingTransactionLiveData.value = data
    }

    fun updateTransaction(transaction: Transaction) = viewModelScope.launch {
        useCase.updatePendingTransaction(transaction)
    }
}