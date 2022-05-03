package com.kahuis.repairtool.presentation.repairs.add_repair

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
                title = {
                    Text(
                        text = "Welkom ${Constants.userName}",
                        color = MaterialTheme.colors.primary
                    )
                },
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
                backgroundColor = MaterialTheme.colors.secondary,
                elevation = 10.dp
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
            FloatingActionButton(
                shape = CircleShape,
                onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Filled.Done, contentDescription = "Button Done")
            }
        },

        content = {
            Box(modifier = Modifier.fillMaxSize()) {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(20.dp)
                ) {
                    item {
                        Text(
                            text = "Klus aanmelden",
                            style = MaterialTheme.typography.h3,
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
private fun CreateSpace(){
    Spacer(modifier = Modifier.height(10.dp))
}