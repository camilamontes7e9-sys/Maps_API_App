package com.example.mapsapiapp.ui.navigation


import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.mapsapiapp.ui.screens.MarkerListScreen
import com.example.mapsapiapp.ui.screens.MarkerScreen
import com.example.mapsapiapp.ui.screens.MapsScreen
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