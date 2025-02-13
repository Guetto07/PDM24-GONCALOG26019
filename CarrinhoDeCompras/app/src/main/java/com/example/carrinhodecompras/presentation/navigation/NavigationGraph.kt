package com.example.carrinhodecompras.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.carrinhodecompras.presentation.screens.ProdutoScreen
import com.example.carrinhodecompras.presentation.screens.CarrinhoScreen
import com.example.carrinhodecompras.presentation.screens.LoginScreen

@Composable
fun NavigationGraph(
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = Screens.LoginScreen.route
    ) {
        composable(route = Screens.ProdutoScreen.route) {
            ProdutoScreen(navController = navController)
        }

        composable(route = Screens.CarrinhoScreen.route) {
            CarrinhoScreen(navController = navController)
        }

        composable(route = Screens.LoginScreen.route) {
            LoginScreen(navController = navController)
        }

    }
}

sealed class Screens(val route: String) {
    object ProdutoScreen : Screens("produto_screen")
    object CarrinhoScreen : Screens("carrinho_screen")
    object LoginScreen : Screens("login_screen")
}
