package com.example.mapsapiapp.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mapsapiapp.view.MarkerListScreen
import com.example.mapsapiapp.view.MarkerScreen
import com.example.mapsapiapp.view.MapsScreen
import com.example.mapsapiapp.viewModel.MapsViewModel

@Composable
fun NavigationWrapper(
    navController: NavHostController,
    viewModel: MapsViewModel
){
    NavHost(
        navController = navController,
        startDestination = Routes.MapsScreen.route
    ) {
        composable(Routes.MapsScreen.route) { MapsScreen(navController, viewModel)}
        composable(Routes.MarkerScreen.route) { MarkerScreen(navController, viewModel)}
        composable(Routes.MarkerListScreen.route) { MarkerListScreen(navController, viewModel) }

    }
}