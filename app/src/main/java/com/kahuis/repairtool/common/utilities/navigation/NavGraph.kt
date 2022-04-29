package com.kahuis.repairtool.common.utilities.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.kahuis.repairtool.presentation.login.LoginScreen
import com.kahuis.repairtool.presentation.repairs.repair_detail.RepairDetailScreen
import com.kahuis.repairtool.presentation.repairs.repair_list.RepairListScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.LoginScreen.route
    )
    {
        composable(
            route = Screen.LoginScreen.route
        ) {
            LoginScreen(navController)
        }
        composable(
            route = Screen.RepairListScreen.route + "/{uName}", //?uName= ==optional
            arguments = listOf(
                navArgument("uName") {
                    type = NavType.StringType
                    defaultValue = "Test"
                }
            )
        ) { entry ->
            RepairListScreen(
                uName = entry.arguments?.getString("uName"),
                navController
            )
        }
        composable(
            route = Screen.RepairDetailScreen.route
        ) {
            RepairDetailScreen()
        }
    }
}