package com.kahuis.repairtool.common.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kahuis.repairtool.presentation.login.LoginScreen
import com.kahuis.repairtool.presentation.reparations.add_reparation.AddRepair
import com.kahuis.repairtool.presentation.reparations.reparation_detail.RepairDetailScreen
import com.kahuis.repairtool.presentation.reparations.reparation_list.RepairListScreen

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
            route = Screen.ReparationListScreen.route
        ) {
            RepairListScreen(navController)
        }
        composable(
            route = Screen.ReparationDetailScreen.withArgs("{repairId}")
        ) {
            RepairDetailScreen(navController)
        }
        composable(
            route = Screen.AddReparationScreen.route
        ) {
            AddRepair(navController)
        }
    }
}