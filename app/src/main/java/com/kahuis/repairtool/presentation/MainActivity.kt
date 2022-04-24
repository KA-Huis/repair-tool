package com.kahuis.repairtool.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import com.kahuis.repairtool.presentation.login.LoginView
import com.kahuis.repairtool.presentation.ui.theme.RepairToolTheme

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