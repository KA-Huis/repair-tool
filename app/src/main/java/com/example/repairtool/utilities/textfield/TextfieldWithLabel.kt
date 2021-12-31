package com.example.repairtool.utilities.textfield

import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp

@Composable
fun singleLineInputLabel(label: String): String {
    var value by rememberSaveable { mutableStateOf("") }
    TextField(
        singleLine = true,
        value = value,
        onValueChange = { value = it},
        label = { Text(label, color = MaterialTheme.colors.secondary) },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            textColor = MaterialTheme.colors.secondary
        ),
        modifier = Modifier.padding(2.dp)
    )
    return value
}

@Composable
fun singelLinePasswordLabel(label: String) : String {
    var value by rememberSaveable { mutableStateOf("") }
    TextField(
        singleLine = true,
        value = value,
        onValueChange = { value = it},
        label = { Text(label, color = MaterialTheme.colors.secondary) },
        visualTransformation = PasswordVisualTransformation(),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            textColor = MaterialTheme.colors.secondary
        ),
        modifier = Modifier
            .padding(2.dp)
    )
    return value
}