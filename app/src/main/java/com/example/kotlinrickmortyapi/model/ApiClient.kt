package com.example.kotlinrickmortyapi.model

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


class ApiClient {

    private val base_url = "https://rickandmortyapi.com/api/"
    private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder().baseUrl(base_url).addConverterFactory(MoshiConverterFactory.create(moshi)).build()
    }
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}

interface ApiService {
    //Use Retrofit Call interface to send out a request to webserver and store the response as RickMortyCharacterList
    @GET("character")
    fun getRickMortyCharacters(@Query("page")page:String) : Call<RickMortyCharactersList>

}