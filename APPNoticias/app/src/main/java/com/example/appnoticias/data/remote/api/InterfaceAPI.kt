package com.example.appnoticias.data.remote.api

import com.example.appnoticias.data.remote.model.ReceberDados
import retrofit2.http.GET

interface AppNoticiasAPI {
    @GET("top?api_token=r7Z6KwVzASrrvqhCFVr5RWIaaQwzSWS1AvOJyqVm")
    suspend fun ObterNoticias() : ReceberDados
}


//r7Z6KwVzASrrvqhCFVr5RWIaaQwzSWS1AvOJyqVm