package com.example.repairtool.utilities.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.repairtool.LoginNav
import com.example.repairtool.volunteer.RepairView

//These functions creating the navigation from loginscreen to the repairlist (Seen by volunteers(for now))
@Composable
fun LoginToRepairList() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {
        composable(route = Screen.LoginScreen.route) {
            LoginNav(navController)
        }
        composable(
            route = Screen.RepairListScreen.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = ""
                    nullable = true
                }
            )
        ) { entry ->
            RepairView(name = entry.arguments?.getString("name"))
        }
    }
}
