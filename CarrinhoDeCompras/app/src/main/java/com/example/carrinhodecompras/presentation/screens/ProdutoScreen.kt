package com.example.carrinhodecompras.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.carrinhodecompras.data.model.Produto
import com.example.carrinhodecompras.presentation.navigation.Screens
import com.example.carrinhodecompras.presentation.viewmodels.CartViewModel
import com.example.carrinhodecompras.presentation.viewmodels.LoginViewModel
import com.example.carrinhodecompras.presentation.viewmodels.ProdutoViewModel

@Composable
fun ProdutoScreen(
    navController: NavController,
    produtoViewModel: ProdutoViewModel = viewModel(),
    cartViewModel: CartViewModel = viewModel(),
    loginViewModel: LoginViewModel = viewModel()
) {
    val produtos = produtoViewModel.state.value

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Lista de Produtos", modifier = Modifier.align(Alignment.CenterHorizontally))

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(produtos) { produto ->
                ProdutoRow(
                    produto = produto,
                    onAddToCart = {
                        if (produto.id.isNotBlank()) {
                            cartViewModel.addToCart(produto)
                        }
                    }
                )
            }
        }

        Button(
            onClick = { navController.navigate(Screens.CarrinhoScreen.route) },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Ir para o Carrinho")
        }

        Button(
            onClick = {
                loginViewModel.isLoggedIn.value = false
                navController.navigate(Screens.LoginScreen.route)
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Voltar para Login")
        }
    }
}



@Composable
fun ProdutoRow(
    produto: Produto,
    onAddToCart: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = produto.name)
            Text(text = "Preço: ${produto.price}")
        }
        Button(onClick = onAddToCart) {
            Text(text = "Adicionar")
        }
    }
}
