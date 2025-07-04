package com.example.cinenowapp

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.cinenowapp.detail.presentation.MovieDetailViewModel
import com.example.cinenowapp.detail.presentation.ui.MovieDetailScreen
import com.example.cinenowapp.list.presentation.MovieListViewModel
import com.example.cinenowapp.list.presentation.ui.MovieListScreen

@Composable
fun MovieNowApp(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "movieList") {
        composable(route = "movieList"){
            MovieListScreen(navController)
        }
        composable(
            route = "movieDetail" + "/{itemId}",
            arguments = listOf(navArgument("itemId"){
                type = NavType.StringType
            })
        ){backStackEntry ->
            val movieId = requireNotNull(backStackEntry.arguments?.getString("itemId"))
            MovieDetailScreen(movieId, navController)
        }
    }
}