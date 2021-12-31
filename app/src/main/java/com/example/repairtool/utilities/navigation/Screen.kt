package com.example.repairtool.utilities.navigation

import com.example.repairtool.R

sealed class Screen(
    val route: String,
    val label: String,
    val icon: Int
) {
    object RepairListScreen : Screen("repairListScreen", "Reparatie lijst", R.drawable.ic_list_icon)
    object AddRepairScreen : Screen("addRepairScreen", "Reparatie aanmelden", R.drawable.ic_repair_icon)
}