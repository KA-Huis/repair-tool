package com.kahuis.repairtool.common.utilities.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.List
import androidx.compose.ui.graphics.vector.ImageVector

sealed class ScreenOld(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    object RepairListScreenOld : ScreenOld("repairListScreen", "Reparatie lijst", icon = Icons.Filled.List)
    object RepairmanRepairListScreenOld : ScreenOld("repairmanRepairListScreen", "Reparatie lijst", icon = Icons.Filled.List)
    object AddRepairScreenOld : ScreenOld("addRepairScreen", "Reparatie aanmelden", icon = Icons.Filled.Build)
    object EditRepairScreenOld : ScreenOld("editRepairScreen", "Reparatie wijzigen", icon = Icons.Filled.Build)
}