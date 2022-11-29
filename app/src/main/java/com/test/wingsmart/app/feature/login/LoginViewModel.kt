package com.test.wingsmart.app.feature.login

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.wingsmart.domain.usecase.login.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    val loginLiveData: MutableLiveData<Boolean?> = MutableLiveData()

    fun login(username: String, password: String) {
        viewModelScope.launch {
            val data = loginUseCase.login(username, password)
            loginLiveData.value = data
        }
    }
}