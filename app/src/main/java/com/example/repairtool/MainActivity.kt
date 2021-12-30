package com.example.repairtool

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.example.repairtool.login.LoginView
import com.example.repairtool.ui.theme.RepairToolTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RepairToolTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LoginView()
                }
            }
        }
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    RepairToolTheme {
        LoginView()
    }
}