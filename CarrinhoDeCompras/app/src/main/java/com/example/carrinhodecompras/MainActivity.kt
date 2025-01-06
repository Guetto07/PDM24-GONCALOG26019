package com.example.carrinhodecompras

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.example.carrinhodecompras.presentation.navigation.NavigationGraph
import com.example.carrinhodecompras.ui.theme.CarrinhoDeComprasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MainActivity", "App iniciado com sucesso")
        setContent {
            CarrinhoDeComprasTheme {
                val navController = rememberNavController()
                NavigationGraph(navController = navController)
            }
        }
    }
}

