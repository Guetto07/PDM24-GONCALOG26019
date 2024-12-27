package com.example.appnoticias.domain.use_case

import com.example.appnoticias.domain.model.Noticias
import com.example.appnoticias.domain.repository.RepositorioNoticias

class ObterNoticiasUseCase(private val repository: RepositorioNoticias) {
    suspend operator fun invoke(): List<Noticias> {
        return repository.ObterNoticias()
    }
}
