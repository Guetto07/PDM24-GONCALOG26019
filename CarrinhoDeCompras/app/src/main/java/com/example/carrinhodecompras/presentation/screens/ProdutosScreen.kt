package com.example.carrinhodecompras.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.carrinhodecompras.domain.model.Produto
import com.example.carrinhodecompras.presentation.viewmodel.ProdutosViewModel

@Composable
fun ProdutosScreen(
    navController: NavController,
    viewModel: ProdutosViewModel = viewModel()
) {
    val produtos = viewModel.produtos

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Button(onClick = { navController.navigate("carrinho") }) {
            Text("Ir para o Carrinho")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn {
            items(produtos.value) { produto ->
                ProdutoItem(produto = produto, onAddToCart = {
                    viewModel.adicionarProdutoAoCarrinho(produto)
                })
            }
        }
    }
}

@Composable
fun ProdutoItem(produto: Produto, onAddToCart: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        BasicText(text = produto.nome, modifier = Modifier.weight(1f))
        Text(text = "${produto.preco}")
        Spacer(modifier = Modifier.width(8.dp))
        Button(onClick = onAddToCart) {
            Text("Adicionar")
        }
    }
}
