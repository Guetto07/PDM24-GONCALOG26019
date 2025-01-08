package com.example.carrinhodecompras.presentation.viewmodels

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carrinhodecompras.data.model.Produto
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await

class ProdutoViewModel : ViewModel() {
    val state = mutableStateOf<List<Produto>>(emptyList())

    init {
        getProdutos()
    }

    private fun getProdutos() {
        viewModelScope.launch {
            state.value = getProdutosFromFireStore()
        }
    }

    private suspend fun getProdutosFromFireStore(): List<Produto> {
        val db = FirebaseFirestore.getInstance()
        return try {
            val snapshot = db.collection("produto").get().await()
            snapshot.documents.mapNotNull { it.toObject(Produto::class.java) } // Mapeia os documentos para a classe Produto
        } catch (e: FirebaseFirestoreException) {
            Log.d("FirebaseError", "Erro ao buscar produtos: $e")
            emptyList() // Retorna uma lista vazia em caso de erro
        }
    }
}


