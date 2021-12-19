package com.example.repairtool.utilities.navigation

sealed class Screen(val route: String) {
    object LoginScreen: Screen("loginScreen")
    object RepairListScreen: Screen("repairListScreen")


}


