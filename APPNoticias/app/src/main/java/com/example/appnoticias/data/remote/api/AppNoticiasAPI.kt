package com.example.appnoticias.data.remote.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitInstance {
    val api: AppNoticiasAPI by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.thenewsapi.com/v1/news/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(AppNoticiasAPI::class.java)
    }
}