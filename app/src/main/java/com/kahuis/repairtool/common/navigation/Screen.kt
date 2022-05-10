package com.kahuis.repairtool.common.navigation

sealed class Screen(val route: String) {
    object LoginScreen : Screen("login_screen")
    object RepairListScreen : Screen("repair_list_screen")
    object RepairDetailScreen : Screen("repair_detail_screen")
    object AddRepairScreen : Screen("add_repair_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
