package com.example.mapsapiapp.ui.navigation

import kotlinx.serialization.Serializable

sealed class Routes(val route: String) {
    @Serializable
    object MapsScreen: Routes("Home")
    @Serializable
    object MarkerScreen: Routes("MarkerScreen")
    @Serializable
    object MarkerListScreen: Routes("MarkerListScreen")
}