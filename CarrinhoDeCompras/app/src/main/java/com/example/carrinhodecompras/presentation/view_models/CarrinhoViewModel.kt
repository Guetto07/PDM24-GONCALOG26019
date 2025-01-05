package com.example.carrinhodecompras.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carrinhodecompras.domain.model.Produto
import com.example.carrinhodecompras.domain.use_case.AdicionarProdutoCarrinhoUseCase
import com.example.carrinhodecompras.domain.use_case.RemoverProdutoCarrinhoUseCase
import com.example.carrinhodecompras.domain.repository.RepositorioCarrinho
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CarrinhoViewModel(
    private val adicionarProdutoCarrinhoUseCase: AdicionarProdutoCarrinhoUseCase,
    private val removerProdutoCarrinhoUseCase: RemoverProdutoCarrinhoUseCase,
    private val repositorioCarrinho: RepositorioCarrinho // Repositório diretamente aqui
) : ViewModel() {
    private val _carrinhoState = MutableStateFlow<CarrinhoState>(CarrinhoState.Idle)
    val carrinhoState: StateFlow<CarrinhoState> get() = _carrinhoState

    // Função para adicionar produto ao carrinho
    fun adicionarProdutoCarrinho(produto: Produto) {
        viewModelScope.launch {
            try {
                adicionarProdutoCarrinhoUseCase.invoke(produto)
                obterCarrinho() // Atualiza o estado do carrinho
            } catch (e: Exception) {
                _carrinhoState.value = CarrinhoState.Error("An error occurred")
            }
        }
    }

    // Função para remover produto do carrinho
    fun removerProdutoCarrinho(produto: Produto) {
        viewModelScope.launch {
            try {
                removerProdutoCarrinhoUseCase.invoke(produto)
                obterCarrinho() // Atualiza o estado do carrinho
            } catch (e: Exception) {
                _carrinhoState.value = CarrinhoState.Error("An error occurred")
            }
        }
    }

    // Função para obter o carrinho diretamente do repositório
    fun obterCarrinho() {
        _carrinhoState.value = CarrinhoState.Loading
        viewModelScope.launch {
            try {
                val produtos = repositorioCarrinho.obterCarrinho()
                _carrinhoState.value = CarrinhoState.Success(produtos)
            } catch (e: Exception) {
                _carrinhoState.value = CarrinhoState.Error("An error occurred")
            }
        }
    }

    sealed class CarrinhoState {
        object Idle : CarrinhoState()
        object Loading : CarrinhoState()
        data class Success(val produtos: List<Produto>) : CarrinhoState()
        data class Error(val message: String) : CarrinhoState()
    }
}
