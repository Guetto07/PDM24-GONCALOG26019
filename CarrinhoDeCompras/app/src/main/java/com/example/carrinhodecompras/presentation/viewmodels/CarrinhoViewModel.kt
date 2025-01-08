package com.example.carrinhodecompras.presentation.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.carrinhodecompras.data.model.Produto

data class CartItem(
    val produto: Produto,
    var quantity: Int = 1
)

class CartViewModel : ViewModel() {
    val cartItems = mutableStateListOf<CartItem>()

    fun addToCart(produto: Produto) {
        val existingItem = cartItems.find { it.produto.id == produto.id }
        if (existingItem != null) {
            existingItem.quantity++
        } else {
            cartItems.add(CartItem(produto = produto))
        }
    }

    fun removeFromCart(produto: Produto) {
        val existingItem = cartItems.find { it.produto.id == produto.id }
        if (existingItem != null) {
            if (existingItem.quantity > 1) {
                existingItem.quantity--
            } else {
                cartItems.remove(existingItem)
            }
        }
    }
}
