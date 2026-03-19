package com.example.mapsapiapp.ui.navigation

sealed class Routes(val route: String) {
    object MapsScreen: Routes("Home")
    object MarkerScreen: Routes("MarkerScreen")
    object MarkerListScreen: Routes("MarkerListScreen")
}