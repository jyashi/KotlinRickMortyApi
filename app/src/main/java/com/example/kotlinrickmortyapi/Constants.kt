package com.example.kotlinrickmortyapi

import com.example.kotlinrickmortyapi.model.RickMortyCharacter

fun placeHolderList(): List<RickMortyCharacter>{
    return listOf(
        RickMortyCharacter(name = "Name", gender = "Null", image = "",
            id = 0, species = "", status = ""))

}