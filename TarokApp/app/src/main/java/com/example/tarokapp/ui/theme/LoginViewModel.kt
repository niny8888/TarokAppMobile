package com.example.tarokapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

sealed class LoginState {
    object Idle : LoginState()
    object Loading : LoginState()
    data class Success(val token: String) : LoginState()
    data class Error(val error: String) : LoginState()
}

class LoginViewModel : ViewModel() {
    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> = _loginState

    fun login(username: String, password: String) {
        _loginState.value = LoginState.Loading
        // Simulate login
        if (username == "test" && password == "password") {
            _loginState.value = LoginState.Success("sample-token")
        } else {
            _loginState.value = LoginState.Error("Invalid credentials")
        }
    }
}
