package com.example.carrinhodecompras.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.carrinhodecompras.presentation.viewmodels.LoginViewModel
import com.example.carrinhodecompras.presentation.navigation.Screens

@Composable
fun LoginScreen(
    navController: NavController,
    loginViewModel: LoginViewModel = viewModel()
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Login")

        // Campo de texto para o email
        BasicTextField(
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            textStyle = androidx.compose.ui.text.TextStyle(color = Color.Black)
        )
        Text(text = "Email")

        // Campo de texto para a senha
        BasicTextField(
            value = password,
            onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            textStyle = androidx.compose.ui.text.TextStyle(color = Color.Black)
        )
        Text(text = "Senha")

        // Mensagem de erro, se houver
        if (errorMessage.isNotEmpty()) {
            Text(text = errorMessage, color = Color.Red)
        }

        // Botão de login
        Button(
            onClick = {
                loginViewModel.login(email, password) { success ->
                    if (success) {
                        navController.navigate(Screens.ProdutoScreen.route)
                    } else {
                        errorMessage = "Erro de login. Verifique suas credenciais."
                    }
                }
            }
        ) {
            Text("Login")
        }
    }
}
