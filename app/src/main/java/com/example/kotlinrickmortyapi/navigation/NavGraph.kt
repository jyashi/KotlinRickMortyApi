package com.example.kotlinrickmortyapi.navigation

sealed class NavigationGraph(val route: String) {
    object MainPage: NavigationGraph(route = "main_page")
    object DetailPage: NavigationGraph(route = "detail_page")
}