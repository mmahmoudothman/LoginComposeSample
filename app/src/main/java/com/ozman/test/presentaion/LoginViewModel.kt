package com.ozman.test.presentaion

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ozman.test.data.remote.response.LoginResponse
import com.ozman.test.domain.reposint.LoginRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: LoginRepository
) : ViewModel() {

    private val _loginState = MutableStateFlow<LoginResponse?>(null)
    val loginState: StateFlow<LoginResponse?> = _loginState.asStateFlow()

    fun login(username: String, password: String) {
        viewModelScope.launch {
            repository.login(username, password)
                .catch { e ->
                    Log.e("LoginError", "Login failed: ${e.message}")
                    _loginState.value = LoginResponse(success = false, message = "Login failed: ${e.message}")
                }
                .collect { response ->
                    _loginState.value = response
                }
        }
    }
}
