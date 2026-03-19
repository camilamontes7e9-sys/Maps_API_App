package com.example.mapsapiapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.mapsapiapp.viewModel.MapsViewModel

@Composable
fun MarkerScreen(navController: NavController, viewModel: MapsViewModel){
    var myText by remember()  { mutableStateOf("")}
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        OutlinedTextField(
            value = myText,
            onValueChange = { myText = it },
            label = { Text("Enter your name") },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Green,
                unfocusedContainerColor = Color.Gray)
        )

        OutlinedTextField(
            value = myText,
            onValueChange = { myText = it },
            label = { Text("Enter your name") },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Green,
                unfocusedContainerColor = Color.Gray)
        )
    }
}