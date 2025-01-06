package com.example.carrinhodecompras.presentation.viewmodel

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
            _produtos.value = obterProdutosUseCase()
        }
    }

    fun adicionarProdutoAoCarrinho(produto: Produto) {
        viewModelScope.launch {
            adicionarProdutoCarrinhoUseCase(produto)
        }
    }
}