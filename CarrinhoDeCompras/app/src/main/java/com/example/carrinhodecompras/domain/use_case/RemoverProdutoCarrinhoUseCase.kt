package com.example.carrinhodecompras.domain.use_case

import com.example.carrinhodecompras.domain.model.Produto
import com.example.carrinhodecompras.domain.repository.RepositorioCarrinho

class RemoverProdutoCarrinhoUseCase(private val repositorio: RepositorioCarrinho) {
    suspend operator fun invoke(produto: Produto) {
        repositorio.removerProduto(produto)
    }
}