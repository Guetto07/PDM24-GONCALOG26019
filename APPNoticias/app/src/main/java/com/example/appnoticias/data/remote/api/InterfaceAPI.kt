package com.example.appnoticias.data.remote.api

import com.example.appnoticias.data.remote.model.NoticiasInfoDTO
import com.example.appnoticias.data.remote.model.ReceberDados
import retrofit2.http.GET
import retrofit2.http.Path

interface AppNoticiasAPI {
    @GET("top?api_token=r7Z6KwVzASrrvqhCFVr5RWIaaQwzSWS1AvOJyqVm")
    suspend fun ObterNoticias() : ReceberDados

    @GET("news/{uuid}?api_token=r7Z6KwVzASrrvqhCFVr5RWIaaQwzSWS1AvOJyqVm")
    suspend fun ObterNoticiaInfo(@Path("uuid") noticiaId: String): NoticiasInfoDTO
}


//r7Z6KwVzASrrvqhCFVr5RWIaaQwzSWS1AvOJyqVm