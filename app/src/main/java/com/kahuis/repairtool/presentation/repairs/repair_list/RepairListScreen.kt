package com.kahuis.repairtool.presentation.repairs.repair_list

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kahuis.repairtool.common.Constants.userName
import com.kahuis.repairtool.common.navigation.Screen

@Composable
fun RepairListScreen(
    navController: NavController,
    viewModel: RepairListViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Welkom $userName",
                        color = MaterialTheme.colors.primary
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(Screen.LoginScreen.route) {
                            popUpTo(Screen.LoginScreen.route) {
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
                onClick = {
                    navController.navigate(Screen.AddRepairScreen.route) {
                        popUpTo(Screen.AddRepairScreen.route) {
                            inclusive = true
                        }
                    }
                }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = "Create button")
            }
        },
        //TODO delete this content and UNCOMMENT the real content!! T
        //This is to save some API requests :)
        content = {
            Text(
                text = "No content",
                color = MaterialTheme.colors.primary
            )
        },
/*
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val state = viewModel.state.value
                Box(modifier = Modifier.fillMaxSize()) {
                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                        items(state.repairs) { repair ->
                            repairId = repair.id
                            RepairListItem(
                                repair = repair,
                                onItemClick = {
                                    navController.navigate(
                                        Screen.RepairDetailScreen.withArgs(
                                            repairId
                                        )
                                    )
                                }
                            )
                        }
                    }
                    if (state.error.isNotBlank()) {
                        Text(
                            text = state.error,
                            color = MaterialTheme.colors.error,
                            textAlign = TextAlign.Center,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 20.dp)
                                .align(Alignment.Center)
                        )
                    }
                    if (state.isLoading) {
                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                    }
                }
            }
        }

        import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kahuis.repairtool.common.Constants.repairId
import com.kahuis.repairtool.common.Constants.userName
import com.kahuis.repairtool.common.navigation.Screen
import com.kahuis.repairtool.presentation.repairs.repair_list.components.RepairListItem


        */
    )
}