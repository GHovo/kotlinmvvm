package com.example.mykotlinapicall.manager

import com.example.mykotlinapicall.utils.Constants
import com.example.mykotlinapicall.webServices.ApiService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitManager {

    val apiService: ApiService

    init{
        val client = OkHttpClient.Builder().build()

        apiService = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(ApiService::class.java)
    }
}