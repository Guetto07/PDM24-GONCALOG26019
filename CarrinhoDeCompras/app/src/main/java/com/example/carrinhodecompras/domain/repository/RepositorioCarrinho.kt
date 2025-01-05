package com.example.carrinhodecompras.domain.repository

import com.example.carrinhodecompras.domain.model.Produto

interface RepositorioCarrinho {
    suspend fun adicionarProduto(produto: Produto)
    suspend fun removerProduto(produto: Produto)
    suspend fun obterCarrinho(): List<Produto>
}