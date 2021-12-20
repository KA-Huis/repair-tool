package com.example.repairtool.utilities.navigation

sealed class Screen(val route: String) {
    object LoginScreen: Screen("loginScreen")
    object RepairListScreen: Screen("repairListScreen")

    fun withArgs(vararg args: String) : String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}


