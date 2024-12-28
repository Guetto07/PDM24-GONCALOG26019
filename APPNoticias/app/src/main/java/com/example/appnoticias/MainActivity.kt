package com.example.appnoticias

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.appnoticias.presentation.screens.NoticiasInfoScreen
import com.example.appnoticias.presentation.screens.NoticiasScreen
import com.example.appnoticias.presentation.view_models.ObterNoticiasViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val viewModel = ObterNoticiasViewModel() // Crie ou obtenha a instância do ViewModel

            NavHost(navController = navController, startDestination = "noticiasScreen") {
                composable("noticiasScreen") {
                    NoticiasScreen(viewModel = viewModel, navController = navController)
                }
                composable("noticiasInfoScreen/{uuid}") { backStackEntry ->
                    val uuid = backStackEntry.arguments?.getString("uuid")
                    NoticiasInfoScreen(viewModel = viewModel, navController = navController, uuid = uuid)
                }
            }
        }
    }
}
