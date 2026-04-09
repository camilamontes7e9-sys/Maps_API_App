package com.example.mapsapiapp.ui.create

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun CreateMarkerScreen(viewmodel: CreateMarkerViewModel = viewModel()){
    val permissionManager = rememberPermissionmanager(AppPermission.CameraAudio)

}