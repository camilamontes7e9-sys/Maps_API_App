package com.example.mapsapiapp.navigation

sealed class Routes(val route: String) {
    object MapsScreen: Routes("MapsScreen")
    object MarkerScreen: Routes("MarkerScreen")
    object MarkerListScreen: Routes("MarkerListScreen")
}