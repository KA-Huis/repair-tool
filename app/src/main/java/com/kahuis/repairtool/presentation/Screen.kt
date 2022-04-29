package com.kahuis.repairtool.presentation

sealed class Screen(val route: String) {
    object LoginScreen: Screen("login_screen")
    object RepairListScreen: Screen("repair_list_screen")
    object RepairDetailScreen: Screen("repair_detail_screen")
}
