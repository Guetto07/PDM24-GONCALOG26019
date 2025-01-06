package com.example.carrinhodecompras.presentation.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun LoginScreen(navController: NavController) {
    Column {
        Text(text = "Tela de Login")
        Button(onClick = { navController.navigate("produtos") }) {
            Text("Entrar")
        }
    }
}