package com.example.carrinhodecompras.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.carrinhodecompras.presentation.viewmodels.ProdutoViewModel

@Composable
fun ProdutoScreen(
    produtoViewModel: ProdutoViewModel = viewModel()
) {
    val produto = produtoViewModel.state.value

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "ID: ${produto.id}")
        Text(text = "Name: ${produto.name}")
        Text(text = "Price: ${produto.price}")
    }

    // LaunchedEffect opcional para debug
    LaunchedEffect(Unit) {
        println("Produto carregado: $produto")
    }
}
