package com.example.repairtool

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.repairtool.login.LoginView
import com.example.repairtool.ui.theme.RepairToolComposeTheme
import com.example.repairtool.utilities.navigation.LoginToRepairList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RepairToolComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LoginToRepairList() //Creates and returns navigation from login to repairlist
                }
            }
        }
    }
}

@Composable
fun LoginNav(navController: NavController) {
    LoginView(navController)
}

@Preview(
    showSystemUi = true,
    showBackground = true,
    name = "LightMode"
)
@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DarkMode"
)
@Composable
private fun DefaultPreview() {
    RepairToolComposeTheme {
        val navController = rememberNavController()
        LoginView(navController)
    }
}