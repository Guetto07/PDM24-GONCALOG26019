package com.example.carrinhodecompras.presentation.viewmodels

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.google.firebase.auth.FirebaseAuth

class LoginViewModel : ViewModel() {
    val isLoggedIn = mutableStateOf(false)

    // Função para fazer o login
    fun login(email: String, password: String, onComplete: (Boolean) -> Unit) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    isLoggedIn.value = true
                } else {
                    isLoggedIn.value = false
                }
                onComplete(task.isSuccessful)
            }
    }
}
