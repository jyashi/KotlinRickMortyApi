package com.example.kotlinrickmortyapi.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.kotlinrickmortyapi.MainViewModel
import com.example.kotlinrickmortyapi.components.DetailsPage
import com.example.kotlinrickmortyapi.components.LazyListColumn
import com.example.kotlinrickmortyapi.components.testPg


@Composable
fun Navigation() {
    val mainModel: MainViewModel = viewModel()
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationGraph.MainPage.route) {
        composable(route = NavigationGraph.MainPage.route) {
            LazyListColumn(navController = navController)

        }
        composable(route = NavigationGraph.DetailPage.route) {
            println("View model address was --> $mainModel")
            DetailsPage(index = 0, navController = navController, mainModel = mainModel)
//            testPg(navController = navController)
        }
    }

}