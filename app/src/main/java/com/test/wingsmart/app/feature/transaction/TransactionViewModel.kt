package com.test.wingsmart.app.feature.transaction

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.wingsmart.domain.model.Transaction
import com.test.wingsmart.domain.usecase.transaction.TransactionUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TransactionViewModel @Inject constructor(
    private val useCase: TransactionUseCase
) : ViewModel() {

    val pendingTransactionLiveData = MutableLiveData<Transaction?>()
    val allTransactionLiveData = MutableLiveData<List<Transaction>?>()

    fun getPendingTransaction() = viewModelScope.launch {
        val data = useCase.getPendingTransaction()
        pendingTransactionLiveData.value = data
    }

    fun getAllTransaction() = viewModelScope.launch {
        val data = useCase.getAllTransaction()
        allTransactionLiveData.value = data
    }

    fun updateTransaction(transaction: Transaction) = viewModelScope.launch {
        useCase.updatePendingTransaction(transaction)
    }
}