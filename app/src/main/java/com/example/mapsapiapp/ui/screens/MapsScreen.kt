package com.example.mapsapiapp.ui.screens

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mapsapiapp.viewModel.MapsViewModel
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@SuppressLint("UnrememberedMutableState")
@Composable
fun MapsScreen(navController: NavController, viewModel: MapsViewModel) {
    Column(modifier = Modifier.fillMaxSize()) {
        val itb = LatLng(41.4534225, 2.1837151)
        val cameraPositionState = rememberCameraPositionState {
            position = CameraPosition.fromLatLngZoom(itb, 17f)
        }

        GoogleMap(
            modifier = Modifier.fillMaxSize(), cameraPositionState = cameraPositionState,
            onMapClick = {
                Log.d("MAP CLICKED", it.toString())
            }, onMapLongClick = {
                Log.d("MAP CLICKED LONG", it.toString())
            }){
            Marker(
                state = MarkerState(position = itb), title = "ITB",
                snippet = "Marker at ITB")
        }


    }
}

