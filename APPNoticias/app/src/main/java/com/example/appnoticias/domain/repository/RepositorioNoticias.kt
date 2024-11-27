package com.example.appnoticias.domain.repository

import com.example.appnoticias.domain.model.Noticias

interface RepositorioNoticias {
    suspend fun ObterNoticias() : List<Noticias>
}