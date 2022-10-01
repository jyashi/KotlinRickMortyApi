package com.example.kotlinrickmortyapi.navigation

sealed class NavGraph(val route: String) {
    object MainPage: NavGraph(route = "main_page")
    object DetailPage: NavGraph(route = "detail_page")
}