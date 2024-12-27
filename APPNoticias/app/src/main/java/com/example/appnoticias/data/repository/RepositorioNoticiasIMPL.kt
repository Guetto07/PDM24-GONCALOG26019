package com.example.appnoticias.data.repository

import com.example.appnoticias.data.remote.api.AppNoticiasAPI
import com.example.appnoticias.domain.model.Noticias
import com.example.appnoticias.domain.model.NoticiasInfo
import com.example.appnoticias.domain.repository.RepositorioNoticias

class RepositorioNoticiasIMPL(private val api: AppNoticiasAPI) : RepositorioNoticias {
    override suspend fun ObterNoticias(): List<Noticias> {
        return api.ObterNoticias().data.map {
            it.CriarNoticia()
        }
    }

    override suspend fun ObterNoticiasInfo(uuid: String): NoticiasInfo {
        val noticiaInfoDTO = api.ObterNoticiaInfo(uuid)
        return noticiaInfoDTO.CriarNoticiaInfo()
    }
}
