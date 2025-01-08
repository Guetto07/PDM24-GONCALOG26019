package com.example.carrinhodecompras.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.carrinhodecompras.data.model.CartItem
import com.example.carrinhodecompras.presentation.navigation.Screens
import com.example.carrinhodecompras.presentation.viewmodels.CartViewModel

@Composable
fun CarrinhoScreen(
    navController: NavController,
    cartViewModel: CartViewModel = viewModel()
) {
    val cartItems = cartViewModel.cartItems

    LaunchedEffect(Unit) {
        cartViewModel.getCartItems()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Carrinho de Compras", modifier = Modifier.align(Alignment.CenterHorizontally))

        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(cartItems) { cartItem ->
                CartItemRow(
                    cartItem = cartItem,
                    onAdd = { cartViewModel.addToCart(cartItem.produto) },
                    onRemove = { cartViewModel.removeFromCart(cartItem.produto) }
                )
            }
        }

        Button(
            onClick = { navController.navigate(Screens.ProdutoScreen.route) },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Voltar para Produtos")
        }
    }
}

@Composable
fun CartItemRow(
    cartItem: CartItem,
    onAdd: () -> Unit,
    onRemove: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = cartItem.produto.name)
        Row(verticalAlignment = Alignment.CenterVertically) {
            Button(onClick = onRemove) { Text(text = "-") }
            Text(text = " ${cartItem.quantity} ", modifier = Modifier.padding(horizontal = 8.dp))
            Button(onClick = onAdd) { Text(text = "+") }
        }
    }
}
