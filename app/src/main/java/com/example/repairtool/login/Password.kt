package com.example.repairtool.login

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun getPassword() : String {
    var text by remember { mutableStateOf("") }
    TextField(
        maxLines = 1,
        value = text,
        onValueChange = { text = it},
        label = { Text("Wachtwoord", color = MaterialTheme.colors.secondary) },
        visualTransformation = PasswordVisualTransformation(),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            textColor = MaterialTheme.colors.secondary
        ),
        modifier = Modifier
            .padding(2.dp)
    )
    return text
}