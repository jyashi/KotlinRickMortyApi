package com.example.kotlinrickmortyapi.navigation

sealed class NavigationModel(val route: String) {
    object MainPage: NavigationModel(route = "main_page")
    object DetailPage: NavigationModel(route = "detail_page/{index}")

    fun passIndex(index: Int):String{
        return "detail_page/$index"
    }


}