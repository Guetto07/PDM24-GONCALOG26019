package com.example.carrinhodecompras.presentation.view_models

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.carrinhodecompras.domain.model.Produto
import com.example.carrinhodecompras.domain.use_case.ObterProdutosUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProdutosViewModel(private val obterProdutosUseCase: ObterProdutosUseCase) : ViewModel() {
    private val _produtosState = MutableStateFlow<ProdutosState>(ProdutosState.Idle)
    val produtosState: StateFlow<ProdutosState> get() = _produtosState

    fun obterProdutos() {
        _produtosState.value = ProdutosState.Loading
        viewModelScope.launch {
            try {
                val produtos = obterProdutosUseCase.invoke()
                _produtosState.value = ProdutosState.Success(produtos)
            } catch (e: Exception) {
                _produtosState.value = ProdutosState.Error("An error occurred")
            }
        }
    }

    sealed class ProdutosState {
        object Idle : ProdutosState()
        object Loading : ProdutosState()
        data class Success(val produtos: List<Produto>) : ProdutosState()
        data class Error(val message: String) : ProdutosState()
    }
}
