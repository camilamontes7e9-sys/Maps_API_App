package com.example.mapsapiapp.ui.permissions

sealed class MapPermissionState {
    object Requesting : MapPermissionState()
    object ShowDenied : MapPermissionState()
    object ShowPermanentlyDenied : MapPermissionState()
    object NavigateToMap : MapPermissionState()
}