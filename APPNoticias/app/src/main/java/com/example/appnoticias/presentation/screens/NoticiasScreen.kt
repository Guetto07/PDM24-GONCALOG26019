package com.example.appnoticias.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.example.appnoticias.presentation.view_models.ObterNoticiasViewModel

@Composable
fun NoticiasScreen(viewModel: ObterNoticiasViewModel) {

    LaunchedEffect(Unit) {
        viewModel.ProcurarNoticias()
    }

    val noticias by viewModel.noticias.collectAsState()


}