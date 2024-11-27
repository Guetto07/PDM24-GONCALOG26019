package com.example.appnoticias.data.remote.model

import com.example.appnoticias.domain.model.NoticiasInfo

class NoticiasInfoDTO(
    val uuid : String,
    val title : String,
    val url : String,
    val image_url : String,
    val description : String,
    val source : String,
    val published_at : String,
    val language : String,
    val categories : List<String>
)

{
    fun CriarNoticiaInfo() : NoticiasInfo{
        return NoticiasInfo(uuid = uuid, title = title, url = url, image_url = image_url, description = description, source = source, published_at = published_at, language = language, categories = categories)
    }
}