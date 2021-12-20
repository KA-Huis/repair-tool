package com.example.repairtool.ui.theme

import android.icu.lang.UCharacter
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repairtool.R

@Composable
fun Header(name: String?) {
    Row(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
    ) {
        Image(painter = painterResource(id = R.drawable.login_icon),
            contentDescription = "",
            modifier = Modifier.size(55.dp)
        )
        Text(
            text = "Welkom $name",
            modifier = Modifier
                .padding(start = 16.dp, top = 15.dp)
        )
    }
}

//Preview for Android Studio
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RepairToolComposeTheme() {
        Header("Mitch")
    }
}