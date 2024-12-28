package com.example.appnoticias.domain.use_case

import com.example.appnoticias.domain.model.NoticiasInfo
import com.example.appnoticias.domain.repository.RepositorioNoticias

class ObterNoticiasInfoUseCase(private val repository: RepositorioNoticias) {
    suspend operator fun invoke(uuid: String): NoticiasInfo {
        return repository.ObterNoticiasInfo(uuid)
    }
}
