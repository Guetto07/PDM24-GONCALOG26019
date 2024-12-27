package com.example.appnoticias.domain.repository

import com.example.appnoticias.domain.model.Noticias
import com.example.appnoticias.domain.model.NoticiasInfo

interface RepositorioNoticias {
    suspend fun ObterNoticias(): List<Noticias>
    suspend fun ObterNoticiasInfo(uuid: String): NoticiasInfo
}
