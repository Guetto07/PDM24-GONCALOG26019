package com.example.appnoticias.domain.model

class NoticiasInfo(
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