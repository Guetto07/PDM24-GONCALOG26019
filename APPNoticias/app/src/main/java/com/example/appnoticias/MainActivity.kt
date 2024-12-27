package com.example.appnoticias.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.navigation.compose.rememberNavController
import com.example.appnoticias.presentation.screens.NoticiasScreen
import com.example.appnoticias.presentation.view_models.ObterNoticiasViewModel


class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppNoticiasApp()
        }
    }
}

@Composable
fun AppNoticiasApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "noticias_screen") {
        composable("noticias_screen") {
            NoticiasScreen(viewModel(), navController)
        }
        composable("noticias_info_screen/{uuid}") { backStackEntry ->
            val uuid = backStackEntry.arguments?.getString("uuid")
            //uuid?.let {
            //NoticiasInfoScreen(it, viewModel)
        }
    }
}
//}
