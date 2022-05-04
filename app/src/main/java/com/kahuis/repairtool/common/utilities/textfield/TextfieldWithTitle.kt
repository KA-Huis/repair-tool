package com.kahuis.repairtool.common.utilities.textfield

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp

@Composable
fun singleLineInputTitle(title: String) : String {
    var value by rememberSaveable { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = Bold,
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.body1
        )
        TextField(
            singleLine = true,
            value = value,
            onValueChange = { value = it},
            shape = RoundedCornerShape(50.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                backgroundColor = Color.White,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        )
    }
    return value
}

@Composable
fun multiLineInputTitle(title: String) : String {
    var value by rememberSaveable { mutableStateOf("") }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = Bold,
            color = MaterialTheme.colors.primary,
            style = MaterialTheme.typography.body1
        )
        TextField(
            value = value,
            onValueChange = { value = it},
            shape = RoundedCornerShape(50.dp),
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                backgroundColor = Color.White,
                cursorColor = Color.Black,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(top = 8.dp)
        )
    }
    return value
}

