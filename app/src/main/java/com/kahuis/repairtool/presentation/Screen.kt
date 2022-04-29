package com.kahuis.repairtool.presentation

sealed class Screen(val route: String) {
    object RepairListScreen: Screen("repair_list_screen")
    object RepairDetailScreen: Screen("repair_detail_screen")
}
