package com.example.mapsapiapp.model

import kotlinx.serialization.Serializable

@Serializable
data class Task(
    val id: Int? = null,
    val title: String,
    val lat: Float,
    val long: Float,
    val complete: Boolean = false,
    val description: String
)
