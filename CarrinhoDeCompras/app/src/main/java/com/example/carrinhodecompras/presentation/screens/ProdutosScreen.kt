package com.example.carrinhodecompras.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.carrinhodecompras.domain.model.Produto
import com.example.carrinhodecompras.presentation.view_models.ProdutosViewModel

@Composable
fun ProdutosScreen(navController: NavController, viewModel: ProdutosViewModel) {
    // Fetch the products when the screen is loaded
    LaunchedEffect(Unit) {
        viewModel.obterProdutos()
    }

    // Collect the products state from the ViewModel
    val produtosState by viewModel.produtosState.collectAsState()

    // UI for the ProdutosScreen
    when (produtosState) {
        is ProdutosViewModel.ProdutosState.Loading -> {
            // Show loading indicator when the products are being loaded
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }
        is ProdutosViewModel.ProdutosState.Success -> {
            // Show list of products when they are successfully loaded
            val produtos = (produtosState as ProdutosViewModel.ProdutosState.Success).produtos
            LazyColumn(
                modifier = Modifier.fillMaxSize().padding(16.dp)
            ) {
                items(produtos.size) { index ->
                    ProdutoItem(produto = produtos[index], onAddToCart = {
                        // Handle adding product to cart
                    })
                }
            }
        }
        is ProdutosViewModel.ProdutosState.Error -> {
            // Show error message if an error occurs while loading the products
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = (produtosState as ProdutosViewModel.ProdutosState.Error).message)
            }
        }
        else -> {
            // Show a placeholder when in idle state
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "No products available.")
            }
        }
    }

    // Button to navigate to CarrinhoScreen
    Button(
        onClick = { navController.navigate("carrinho") },
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .height(50.dp)
    ) {
        Text(text = "Ir para o Carrinho")
    }
}

@Composable
fun ProdutoItem(produto: Produto, onAddToCart: (Produto) -> Unit) {
    // Display the product's details (name and price)
    Column(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Text(text = produto.nome, style = MaterialTheme.typography.titleMedium)
        Text(text = "R$ ${produto.preco}", style = MaterialTheme.typography.bodyMedium)
        Spacer(modifier = Modifier.height(8.dp))

        // Button to add product to cart
        Button(
            onClick = { onAddToCart(produto) },
            modifier = Modifier.fillMaxWidth().height(48.dp)
        ) {
            Text(text = "Adicionar ao Carrinho")
        }
    }
}
