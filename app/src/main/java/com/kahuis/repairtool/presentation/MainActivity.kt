package com.kahuis.repairtool.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kahuis.repairtool.presentation.login.LoginScreen
import com.kahuis.repairtool.presentation.repairs.repair_list.RepairListScreen
import com.kahuis.repairtool.presentation.repairs.repair_detail.RepairDetailScreen
import com.kahuis.repairtool.presentation.ui.theme.RepairToolTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RepairToolTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.LoginScreen.route
                    ) {
                        composable(
                            route = Screen.LoginScreen.route
                        ) {
                            LoginScreen(navController)
                        }
                        composable(
                            route = Screen.RepairListScreen.route
                        ) {
                            RepairListScreen(navController)
                        }
                        composable(
                            route = Screen.RepairDetailScreen.route + "/{repairId}"
                        ) {
                            RepairDetailScreen()
                        }
                    }
                }
            }
        }
    }
}