package com.example.mapsapiapp.ui.components

import androidx.compose.ui.graphics.vector.ImageVector
import com.example.mapsapiapp.ui.navigation.Routes


enum class DrawerItem(
    val icon: ImageVector,
    val text: String,
    val route: Routes
) {
    HOME(Icons.Default.Home, "Home", Routes.MapsScreen),
    SETTINGS(Icons.Default.Settings, "Settings", Routes.MarkerListScreen),
    ABOUT(Icons.Default.Info, "About", Routes.MarkerScreen),
}
