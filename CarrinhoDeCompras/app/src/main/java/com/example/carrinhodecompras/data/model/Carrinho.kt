package com.example.carrinhodecompras.data.model

data class CartItem(
    val produto: Produto,
    var quantity: Int = 1
)
