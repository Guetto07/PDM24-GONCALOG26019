package com.example.appnoticias.data.remote.model

import com.example.appnoticias.domain.model.Noticias

data class NoticiasDTO(
    val uuid : String,
    val title : String,
    val url : String
)

{
    fun CriarNoticia() : Noticias{
        return Noticias(uuid = uuid, title = title, url=url)
    }
}