package com.example.repairtoolcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.repairtoolcompose.ui.theme.RepairToolComposeTheme

class Login : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RepairToolComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {

                }
            }
        }
    }
}

@Composable
fun GetName(name: String) {
    Text(text = "Hello $name!")
}

@Composable
fun GetPassword(pwd: String) {

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
    RepairToolComposeTheme {

    }
}