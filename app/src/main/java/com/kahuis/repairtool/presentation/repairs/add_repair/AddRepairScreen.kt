package com.kahuis.repairtool.presentation.repairs.add_repair

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.kahuis.repairtool.common.Constants
import com.kahuis.repairtool.common.navigation.Screen
import com.kahuis.repairtool.common.utilities.textfield.multiLineInputTitle
import com.kahuis.repairtool.common.utilities.textfield.singleLineInputTitle

@Composable
fun AddRepair(
    navController: NavController
) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                MaterialTheme.colors.secondary,
                                MaterialTheme.colors.background
                            )
                        )
                    ),
                title = {
                    Text(
                        text = "Welkom ${Constants.userName}",
                        color = MaterialTheme.colors.primary
                    )
                },
                backgroundColor = Color.Transparent,
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(Screen.RepairListScreen.route) {
                            popUpTo(Screen.RepairListScreen.route) {
                                inclusive = true
                            }
                        }
                    }) {
                        Icon(Icons.Filled.ArrowBack, "backIcon")
                    }
                },
                elevation = 0.dp
            )
        },
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp)),
                cutoutShape = CircleShape,
                elevation = 20.dp,
                backgroundColor = MaterialTheme.colors.secondary
            ) {

            }
        },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        floatingActionButton = {
            IconButton(
                onClick = {
                    navController.navigate(Screen.RepairListScreen.route) {
                        popUpTo(Screen.RepairListScreen.route) {
                            inclusive = true
                        }
                    }
                },
                modifier = Modifier
                    .size(70.dp)
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                MaterialTheme.colors.secondary,
                                MaterialTheme.colors.background
                            )
                        ),
                        shape = CircleShape
                    )
            ) {

                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Button Done",
                    tint = Color.White
                )
            }
        },

        content = { padding ->
            Box(
                modifier = Modifier
                    .padding(padding)
                    .fillMaxSize()
            ) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    item {
                        Text(
                            text = "Klus aanmelden",
                            color = MaterialTheme.colors.secondary,
                            style = MaterialTheme.typography.h3,
                            fontWeight = FontWeight.Bold
                        )
                        CreateSpace()
                        singleLineInputTitle(title = "Titel")

                        CreateSpace()
                        multiLineInputTitle(title = "Omschrijving")

                        CreateSpace()
                        singleLineInputTitle(title = "Locatie")

                        CreateSpace()

                    }
                }
            }
        }
    )
}

@Composable
private fun CreateSpace() {
    Spacer(modifier = Modifier.height(10.dp))
}