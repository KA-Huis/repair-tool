package com.example.repairtool.utilities.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Screen(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    object RepairListScreen : Screen("repairListScreen", "Reparatie lijst", icon = Icons.Filled.List)
    object AddRepairScreen : Screen("addRepairScreen", "Reparatie aanmelden", icon = Icons.Filled.Build)
}