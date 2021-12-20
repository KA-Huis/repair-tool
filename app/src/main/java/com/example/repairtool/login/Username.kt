package com.example.repairtool.login

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun getUsername(): String {
    var text by remember { mutableStateOf("") }
    TextField(
        value = text,
        onValueChange = { text = it},
        label = { Text("Username") },
        colors = TextFieldDefaults.textFieldColors(
        backgroundColor = Color.Transparent
        ),
        modifier = Modifier.padding(2.dp)
    )
    return text
}