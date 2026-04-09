package com.example.mapsapiapp.ui.permissions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.example.mapsapiapp.viewModel.MapsViewModel
import io.ktor.websocket.Frame

@Composable
fun PermissionManager(viewModel: MapsViewModel ){
    val permissionManager =
        rememberPermissionManager(AppPermission.Location)

    val uiState by viewModel.uiState

    LaunchedEffect(permissionManager.status) {
        if (permissionManager.status == PermissionStatus.Unknown) {
            permissionManager.requestPermissions()
        }
        viewModel.onPermissionResult(permissionManager.status)
    }

    when (uiState) {
        MapPermissionState.NavigateToMap ->
            Frame.Text("Aquí iría el MAPA")

        MapPermissionState.ShowDenied ->
            PermissionContent(
                PermissionStatus.Denied,
                permissionManager.requestPermissions
            )

        MapPermissionState.ShowPermanentlyDenied ->
            PermissionContent(
                PermissionStatus.PermanentlyDenied,
                {}
            )

        MapPermissionState.Requesting ->
            PermissionContent(
                PermissionStatus.Unknown,
                permissionManager.requestPermissions
            )
    }
}