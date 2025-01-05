package com.example.carrinhodecompras.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.carrinhodecompras.presentation.screens.CarrinhoScreen
import com.example.carrinhodecompras.presentation.screens.LoginScreen
import com.example.carrinhodecompras.presentation.screens.ProdutosScreen

@Composable
fun NavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "login") {
        composable("login") { LoginScreen(navController) }
        composable("produtos") { ProdutosScreen(navController) }
        composable("carrinho") { CarrinhoScreen(navController) }
    }
}
