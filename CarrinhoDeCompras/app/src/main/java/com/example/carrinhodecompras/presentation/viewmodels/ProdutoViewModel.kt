package com.example.carrinhodecompras.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carrinhodecompras.data.model.Produto
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class ProdutoViewModel : ViewModel() {
    val state = mutableStateOf(Produto())

    init {
        fetchProduto()
    }

    private fun fetchProduto() {
        viewModelScope.launch {
            state.value = fetchProdutoFromFirestore()
        }
    }

    private suspend fun fetchProdutoFromFirestore(): Produto {
        val db = FirebaseFirestore.getInstance()
        return try {
            val document = db.collection("produto").limit(1).get().await().documents.firstOrNull()
            document?.toObject(Produto::class.java) ?: Produto()
        } catch (e: Exception) {
            Log.e("ProdutoViewModel", "Erro ao buscar produto: $e")
            Produto()
        }
    }
}
