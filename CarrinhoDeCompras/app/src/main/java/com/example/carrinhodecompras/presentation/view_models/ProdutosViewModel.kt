package com.example.carrinhodecompras.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carrinhodecompras.domain.model.Produto
import com.example.carrinhodecompras.domain.use_case.AdicionarProdutoCarrinhoUseCase
import com.example.carrinhodecompras.domain.use_case.ObterProdutosUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProdutosViewModel(
    private val obterProdutosUseCase: ObterProdutosUseCase,
    private val adicionarProdutoCarrinhoUseCase: AdicionarProdutoCarrinhoUseCase
) : ViewModel() {

    private val _produtos = MutableStateFlow<List<Produto>>(emptyList())
    val produtos: StateFlow<List<Produto>> = _produtos

    fun carregarProdutos() {
        viewModelScope.launch {
            try {
                val resultado = obterProdutosUseCase()
                if (resultado.isNullOrEmpty()) {
                    Log.w("ProdutosViewModel", "Nenhum produto foi encontrado.")
                } else {
                    Log.d("ProdutosViewModel", "Produtos carregados: $resultado")
                }
                _produtos.value = resultado
            } catch (e: Exception) {
                Log.e("ProdutosViewModel", "Erro ao carregar produtos", e)
            }
        }
    }

    fun adicionarProdutoAoCarrinho(produto: Produto) {
        viewModelScope.launch {
            adicionarProdutoCarrinhoUseCase(produto)
        }
    }
}