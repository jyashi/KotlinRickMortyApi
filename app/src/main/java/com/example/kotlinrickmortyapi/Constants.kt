package com.example.kotlinrickmortyapi

import com.example.kotlinrickmortyapi.model.RickMortyCharacter

fun placeHolderList(): List<RickMortyCharacter>{
    return listOf(
        RickMortyCharacter(name = "Name", gender = "Null", image = "",
            id = 0, species = "", status = "", type = "typ", origin = mapOf()
        ))

}

val onError: List<RickMortyCharacter> = listOf(RickMortyCharacter(name = "Network Error", gender = "Null", image = "",
    id = 0, species = "", status = "", type = "type", origin = mapOf()))