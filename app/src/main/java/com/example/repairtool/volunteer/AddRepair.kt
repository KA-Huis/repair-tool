package com.example.repairtool.volunteer

import android.app.Activity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun AddRepair(name: String?) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(
                    text = "Welkom $name",
                    color = MaterialTheme.colors.secondary) },
                actions = {
                    val activity = (LocalContext.current as? Activity)
                    Text(
                        text = "Afmelden",
                        color = MaterialTheme.colors.secondary,
                        modifier = Modifier
                            .padding(16.dp)
                            .clickable(onClick = {
                                activity?.finish()
                            })
                    )
                },
                backgroundColor = MaterialTheme.colors.primary
            )
        }
    ) {

    }
}