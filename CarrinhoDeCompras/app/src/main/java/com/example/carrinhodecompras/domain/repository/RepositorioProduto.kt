package com.example.carrinhodecompras.domain.repository

import com.example.carrinhodecompras.domain.model.Produto

interface RepositorioProdutos {
    suspend fun obterProdutos(): List<Produto>
}