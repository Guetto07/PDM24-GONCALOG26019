package com.example.carrinhodecompras.data.repository

import com.example.carrinhodecompras.domain.model.Produto
import com.example.carrinhodecompras.domain.repository.RepositorioProdutos

class RepositorioProdutosIMPL : RepositorioProdutos {
    override suspend fun obterProdutos(): List<Produto> {
        return listOf(
            Produto(id = "1", nome = "Produto 1", preco = 10.0),
            Produto(id = "2", nome = "Produto 2", preco = 20.0)
        )
    }
}