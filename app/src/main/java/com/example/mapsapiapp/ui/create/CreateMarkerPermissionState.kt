package com.example.mapsapiapp.ui.create

sealed class CreateMarkerPermissionState {
    object Requesting : CreateMarkerPermissionState()
    object ShowDenied : CreateMarkerPermissionState()
    object ShowPermanentlyDenied : CreateMarkerPermissionState()
    object NavigateToMap : CreateMarkerPermissionState()
}