package com.example.appnoticias.data.remote.model

import com.google.gson.annotations.SerializedName

data class ReceberDados(
    @SerializedName("data")
    val data : List<NoticiasDTO>
)
