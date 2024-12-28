package com.example.appnoticias.presentation.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appnoticias.presentation.view_models.ObterNoticiasViewModel


@Composable
fun NoticiasScreen(viewModel: ObterNoticiasViewModel, navController: NavController) {

    LaunchedEffect(Unit) {
        viewModel.ProcurarNoticias()
    }

    val noticias by viewModel.news.collectAsState()

    LazyColumn {
        items(noticias) { noticia ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
                    .clickable {
                        navController.navigate("noticias_info_screen/${noticia.uuid}")
                    }
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = noticia.title)
                    Text(text = noticia.url)
                }
            }
        }
    }
}
