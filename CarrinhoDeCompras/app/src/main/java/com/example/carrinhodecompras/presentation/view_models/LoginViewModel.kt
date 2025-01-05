package com.example.carrinhodecompras.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carrinhodecompras.domain.model.User
import com.example.carrinhodecompras.domain.use_case.LoginUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LoginViewModel(private val loginUseCase: LoginUseCase) : ViewModel() {
    private val _loginState = MutableStateFlow<LoginState>(LoginState.Idle)
    val loginState: StateFlow<LoginState> get() = _loginState

    fun login(email: String, senha: String) {
        _loginState.value = LoginState.Loading
        viewModelScope.launch {
            try {
                val user = loginUseCase.invoke(email, senha)
                if (user != null) {
                    _loginState.value = LoginState.Success(user)
                } else {
                    _loginState.value = LoginState.Error("Invalid credentials")
                }
            } catch (e: Exception) {
                _loginState.value = LoginState.Error("An error occurred")
            }
        }
    }

    sealed class LoginState {
        object Idle : LoginState()
        object Loading : LoginState()
        data class Success(val user: User) : LoginState()
        data class Error(val message: String) : LoginState()
    }
}
