package com.example.carrinhodecompras.domain.use_case

import com.example.carrinhodecompras.domain.model.Produto
import com.example.carrinhodecompras.domain.repository.RepositorioProdutos

class ObterProdutosUseCase(private val repositorio: RepositorioProdutos) {
    suspend operator fun invoke(): List<Produto> {
        return repositorio.obterProdutos()
    }
}