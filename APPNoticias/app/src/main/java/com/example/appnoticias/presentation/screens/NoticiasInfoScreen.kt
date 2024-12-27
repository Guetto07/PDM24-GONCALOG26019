package com.example.appnoticias.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.appnoticias.presentation.view_models.ObterNoticiasViewModel

/*
@Composable
fun NoticiasInfoScreen(uuid: String, viewModel: ObterNoticiasViewModel) {
    LaunchedEffect(uuid) {
        viewModel.ObterNoticiasInfo(uuid)
    }

    val noticiaInfo by viewModel.noticiaInfo.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(noticiaInfo?.title ?: "Detalhes da Notícia") })
        }
    ) {
        noticiaInfo?.let { info ->
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = info.title, style = MaterialTheme.typography.h4)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = info.description, style = MaterialTheme.typography.body1)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Fonte: ${info.source}", style = MaterialTheme.typography.body2)
                Text(text = "Publicado em: ${info.published_at}", style = MaterialTheme.typography.body2)
            }
        }
    }
}
*/