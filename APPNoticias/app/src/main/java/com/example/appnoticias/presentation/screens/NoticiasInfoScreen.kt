package com.example.appnoticias.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.appnoticias.presentation.view_models.ObterNoticiasViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@Composable
fun NoticiasInfoScreen(viewModel: ObterNoticiasViewModel, navController: NavController, uuid: String?) {
    val coroutineScope = rememberCoroutineScope()
    var isLoading by remember { mutableStateOf(true) }
    var loadError by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(uuid) {
        uuid?.let {
            try {
                viewModel.ObterNoticiasInfo(it)
                isLoading = false
            } catch (e: Exception) {
                loadError = e.message
                isLoading = false
            }
        }
    }

    val noticiaInfo by viewModel.noticiaInfo.collectAsState()

    if (isLoading) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
    } else if (loadError != null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text(text = "Erro ao carregar notícia: $loadError")
        }
    } else {
        noticiaInfo?.let { info ->
            Column(modifier = Modifier.padding(16.dp)) {
                Text(text = info.title, style = MaterialTheme.typography.headlineMedium)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = info.description, style = MaterialTheme.typography.bodyLarge)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Fonte: ${info.source}", style = MaterialTheme.typography.bodyMedium)
                Text(text = "Publicado em: ${info.published_at}", style = MaterialTheme.typography.bodyMedium)
            }
        } ?: run {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(text = "Nenhuma informação disponível.")
            }
        }
    }
}
