package com.example.carrinhodecompras.presentation.viewmodels

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.carrinhodecompras.data.model.CartItem
import com.example.carrinhodecompras.data.model.Produto
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore

class CartViewModel : ViewModel() {
    private val db = FirebaseFirestore.getInstance()
    val cartItems = mutableStateListOf<CartItem>()

    fun addToCart(produto: Produto) {
        val userId = FirebaseAuth.getInstance().currentUser?.uid
        userId?.let {
            val cartRef = db.collection("users").document(userId).collection("cart").document(produto.id)
            cartRef.get().addOnSuccessListener { document ->
                if (document.exists()) {
                    val currentQuantity = document.getLong("quantity")?.toInt() ?: 0
                    cartRef.update("quantity", currentQuantity + 1)
                } else {
                    cartRef.set(mapOf(
                        "name" to produto.name,
                        "price" to produto.price,
                        "quantity" to 1
                    ))
                }
            }
        }
    }

    fun removeFromCart(produto: Produto) {
        val userId = FirebaseAuth.getInstance().currentUser?.uid
        userId?.let {
            val cartRef = db.collection("users").document(userId).collection("cart").document(produto.id)
            cartRef.get().addOnSuccessListener { document ->
                if (document.exists()) {
                    val currentQuantity = document.getLong("quantity")?.toInt() ?: 0
                    if (currentQuantity > 1) {
                        cartRef.update("quantity", currentQuantity - 1)
                    } else {
                        cartRef.delete()
                    }
                }
            }
        }
    }

    fun getCartItems() {
        val userId = FirebaseAuth.getInstance().currentUser?.uid
        userId?.let {
            db.collection("users").document(userId).collection("cart")
                .get()
                .addOnSuccessListener { result ->
                    cartItems.clear()
                    result.forEach { document ->
                        val produto = Produto(
                            id = document.id,
                            name = document.getString("name") ?: "",
                            price = document.getString("price") ?: ""
                        )
                        val quantity = document.getLong("quantity")?.toInt() ?: 0
                        cartItems.add(CartItem(produto = produto, quantity = quantity))
                    }
                }
        }
    }
}
