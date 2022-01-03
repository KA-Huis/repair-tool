package com.example.repairtool.repairman

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.repairtool.ui.theme.RepairToolTheme
import com.example.repairtool.utilities.navigation.Screen

class RepairmanActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val items = listOf(Screen.RepairmanRepairListScreen, Screen.EditRepairScreen)
            val uName = intent.getStringExtra("uName")

            RepairToolTheme {
                Scaffold(
                    topBar = { //TopBar creates welcome message and logout option
                        TopAppBar(
                            title = { Text(
                                text = "Welkom $uName",
                                color = MaterialTheme.colors.secondary) },
                            actions = {
                                val activity = (LocalContext.current as? Activity)
                                Text(
                                    text = "Afmelden",
                                    color = MaterialTheme.colors.secondary,
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .clickable(onClick = {
                                            activity?.finish()
                                        })
                                )
                            },
                            backgroundColor = MaterialTheme.colors.primary
                        )
                    },

                    bottomBar = { //BottomBar creates navigation
                        BottomNavigation(
                            backgroundColor = MaterialTheme.colors.primary
                        ) {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentRoute = navBackStackEntry?.arguments?.getString("KEY_ROUTE")

                            items.forEach { screen ->
                                BottomNavigationItem(
                                    icon = { Icon(imageVector = screen.icon,
                                        contentDescription = "") },
                                    label = { Text(screen.label) },
                                    unselectedContentColor = MaterialTheme.colors.secondary,
                                    selected = currentRoute == screen.route,
                                    onClick = {
                                        navController.navigate(screen.route)
                                    }
                                )
                            }
                        }
                    },
                ) { innerPadding -> //Needed so BottomNav doesnt overlap anything
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        NavHost(
                            navController = navController,
                            startDestination = "repairmanRepairListScreen"
                        ) {
                            composable("repairmanRepairListScreen") { RepairmanView() }
                            composable("editRepairScreen") { EditRepair(uName) }
                        }
                    }
                }
            }
        }
    }
}