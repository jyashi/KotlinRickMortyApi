package com.example.kotlinrickmortyapi


import com.example.kotlinrickmortyapi.model.ApiService


class Repository(private val apiService: ApiService) {

    // Define method implementation for fetching data from api and local storage

    fun getRickMortyCharacters(page:String) = apiService.getRickMortyCharacters(page)
}