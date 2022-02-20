package com.example.retrofit_muamarzidantriantoro_21.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrovitClient {
    private const val BASE_URL = "https://learn-retrofit-data.netlify.app"
    val instance: Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(Api::class.java)
    }
}