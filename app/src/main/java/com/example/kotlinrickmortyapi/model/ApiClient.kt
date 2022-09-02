package com.example.kotlinrickmortyapi.model

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory


class ApiClient {

    private val base_url = "https://rickandmortyapi.com/api/"
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder().baseUrl(base_url).addConverterFactory(MoshiConverterFactory.create(moshi)).build()
    }
}