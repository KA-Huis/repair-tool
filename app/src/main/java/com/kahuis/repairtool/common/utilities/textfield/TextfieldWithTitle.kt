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

@Composable
fun singleLineInputTitle(title: String) : String {
    var value by rememberSaveable { mutableStateOf("") }
    Text(
        text = title,
        color = MaterialTheme.colors.secondary
    )
    TextField(
        singleLine = true,
        value = value,
        onValueChange = { value = it},
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            textColor = MaterialTheme.colors.secondary,
            unfocusedIndicatorColor = MaterialTheme.colors.secondary
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
        color = MaterialTheme.colors.secondary,
    )
    TextField(
        value = value,
        onValueChange = { value = it},
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color.Transparent,
            textColor = MaterialTheme.colors.secondary,
            unfocusedIndicatorColor = MaterialTheme.colors.secondary
        ),
        modifier = Modifier.fillMaxWidth()
    )
    return value
}

