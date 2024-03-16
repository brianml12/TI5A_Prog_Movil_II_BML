package com.brian_angel.respuestallamada.navegation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.brian_angel.respuestallamada.ui.screens.HomeScreenUI
import com.brian_angel.respuestallamada.ui.screens.HomeViewModel

@Composable
fun AppNavigation(
    homeViewModel: HomeViewModel
){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home"){
        composable(route = "home") {
            HomeScreenUI(homeViewModel, navController)
        }
    }
}