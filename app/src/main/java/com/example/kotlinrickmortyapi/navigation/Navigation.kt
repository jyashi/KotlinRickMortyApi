package com.example.kotlinrickmortyapi.navigation
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavGraph.MainPage.route ){
        composable(route = NavGraph.MainPage.route) {

        }
    }
}