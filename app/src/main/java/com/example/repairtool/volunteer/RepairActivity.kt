package com.example.repairtool.volunteer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.repairtool.ui.theme.RepairToolTheme
import com.example.repairtool.utilities.navigation.Screen

class RepairActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val items = listOf(Screen.RepairListScreen, Screen.AddRepairScreen)
            val uName = intent.getStringExtra("uName")

            RepairToolTheme {
                Scaffold(
                    bottomBar = {
                        BottomNavigation(
                            backgroundColor = MaterialTheme.colors.primary
                        ) {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentRoute = navBackStackEntry?.arguments?.getString("KEY_ROUTE")

                            items.forEach { screen ->
                                BottomNavigationItem(
                                    icon = { Icon(painterResource(id = screen.icon), contentDescription = screen.route) },
                                    label = { Text(screen.label,
                                        color = MaterialTheme.colors.secondary) },
                                    selected = currentRoute == screen.route,
                                    onClick = {
                                        navController.navigate(screen.route) {
                                            launchSingleTop = true
                                        }
                                    }
                                )
                            }
                        }
                    },
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = "repairListScreen"
                        ) {
                            composable("repairListScreen") { RepairView(uName) }
                            composable("addRepairScreen") { AddRepair(uName) }
                        }
                    }
                }
            }
        }
    }
}

