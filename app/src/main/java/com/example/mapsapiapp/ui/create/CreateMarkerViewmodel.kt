package com.example.mapsapiapp.ui.create

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

import com.google.androidbrowserhelper.trusted.PermissionStatus


class CreateMarkerViewModel: ViewModel() {
    private val _uiState =
        mutableStateOf<CreateMarkerPermissionState>(CreateMarkerPermissionState.Requesting)

    val uiState: MutableState<CreateMarkerPermissionState> = _uiState

    fun onPermissionResult(status: PermissionStatus) {
        _uiState.value = when (status) {
            PermissionStatus.Granted ->
                CreateMarkerPermissionState.NavigateToMap

            PermissionStatus.Denied ->
                CreateMarkerPermissionState.ShowDenied

            PermissionStatus.PermanentlyDenied ->
                CreateMarkerPermissionState.ShowPermanentlyDenied

            PermissionStatus.Unknown ->
                CreateMarkerPermissionState.Requesting
        }
    }
}