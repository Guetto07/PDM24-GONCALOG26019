package com.example.carrinhodecompras.data.repository

import com.example.carrinhodecompras.domain.model.Produto
import com.example.carrinhodecompras.domain.repository.RepositorioCarrinho

class RepositorioCarrinhoIMPL : RepositorioCarrinho {
    private val carrinho = mutableListOf<Produto>()

    override suspend fun adicionarProduto(produto: Produto) {
        carrinho.add(produto)
    }

    override suspend fun removerProduto(produto: Produto) {
        carrinho.remove(produto)
    }

    override suspend fun obterCarrinho(): List<Produto> {
        return carrinho
    }
}

