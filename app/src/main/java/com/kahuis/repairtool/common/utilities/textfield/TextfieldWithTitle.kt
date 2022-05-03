package com.kahuis.repairtool.common.utilities.textfield

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold

@Composable
fun singleLineInputTitle(title: String) : String {
    var value by rememberSaveable { mutableStateOf("") }
    Text(
        text = title,
        fontWeight = Bold,
        style = MaterialTheme.typography.body1
    )
    TextField(
        singleLine = true,
        value = value,
        onValueChange = { value = it},
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent
        ),
        modifier = Modifier.fillMaxWidth()
    )
    return value
}

@Composable
fun multiLineInputTitle(title: String) : String {
    var value by rememberSaveable { mutableStateOf("") }
    Text(
        text = title,
        fontWeight = Bold,
        style = MaterialTheme.typography.body1
    )
    TextField(
        value = value,
        onValueChange = { value = it},
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
        ),
        modifier = Modifier.fillMaxWidth()
    )
    return value
}

