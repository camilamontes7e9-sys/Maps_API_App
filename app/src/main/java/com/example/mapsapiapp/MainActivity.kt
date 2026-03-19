package com.example.mapsapiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.example.mapsapiapp.ui.navigation.NavigationWrapper
import com.example.mapsapiapp.ui.theme.MapsAPIAppTheme
import com.example.mapsapiapp.viewModel.MapsViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MapsAPIAppTheme {
                val navController = rememberNavController()
                val viewModel by viewModels<MapsViewModel>()
                NavigationWrapper(navController, viewModel)
            }
        }
    }
}

