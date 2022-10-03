package com.example.kotlinrickmortyapi.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kotlinrickmortyapi.MainViewModel
import com.example.kotlinrickmortyapi.components.DetailsPage
import com.example.kotlinrickmortyapi.components.LazyListColumn


@Composable
fun NavigationGraph() {
    val mainModel: MainViewModel = viewModel()
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationModel.MainPage.route) {
        composable(route = NavigationModel.MainPage.route) {
            LazyListColumn(navController = navController)

        }
        composable(route = NavigationModel.DetailPage.route,
            arguments = listOf(
                navArgument("index"){
                    type = NavType.IntType
                    defaultValue = 1
                    nullable = false
                }
            )

        ) {
            entry ->
            DetailsPage(index = entry.arguments!!.getInt("index"), navController = navController, mainModel = mainModel)
        }
    }

}