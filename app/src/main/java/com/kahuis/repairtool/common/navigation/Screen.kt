package com.kahuis.repairtool.common.navigation

sealed class Screen(val route: String) {
    object LoginScreen : Screen("login_screen")
    object ReparationListScreen : Screen("repair_list_screen")
    object ReparationDetailScreen : Screen("repair_detail_screen")
    object AddReparationScreen : Screen("add_repair_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
