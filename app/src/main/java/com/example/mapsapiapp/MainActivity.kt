package com.example.mapsapiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.mapsapiapp.navigation.NavigationWrapper
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

