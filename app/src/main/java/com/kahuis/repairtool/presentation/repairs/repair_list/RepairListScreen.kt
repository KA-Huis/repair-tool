package com.kahuis.repairtool.presentation.repairs.repair_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Create
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kahuis.repairtool.common.utilities.navigation.Screen
import com.kahuis.repairtool.presentation.repairs.repair_list.components.RepairListItem

@Composable
fun RepairListScreen(
    uName: String?,
    navController: NavController,
    viewModel: RepairListViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Welkom $uName",
                    color = MaterialTheme.colors.primary)
                },
                navigationIcon = {
                    IconButton(onClick = {
                        navController.navigate(Screen.LoginScreen.route) {
                            popUpTo(Screen.LoginScreen.route)
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
                  Icon(imageVector = Icons.Filled.Create, contentDescription = "Create button")
            }
        },
        content = {
            Text(text = "This is Content",
            color = MaterialTheme.colors.primary)
        }

//        content = {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize(),
//                verticalArrangement = Arrangement.Center,
//                horizontalAlignment = Alignment.CenterHorizontally
//            ) {
//                val state = viewModel.state.value
//                Box(modifier = Modifier.fillMaxSize()) {
//                    LazyColumn(modifier = Modifier.fillMaxSize()) {
//                        items(state.repairs) { repair ->
//                            RepairListItem(
//                                repair = repair,
//                                onItemClick = {
//                                    navController.navigate(Screen.RepairDetailScreen.route + "/${repair.id}")
//                                }
//                            )
//                        }
//                    }
//                    if (state.error.isNotBlank()) {
//                        Text(
//                            text = state.error,
//                            color = MaterialTheme.colors.error,
//                            textAlign = TextAlign.Center,
//                            modifier = Modifier
//                                .fillMaxWidth()
//                                .padding(horizontal = 20.dp)
//                                .align(Alignment.Center)
//                        )
//                    }
//                    if (state.isLoading) {
//                        CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
//                    }
//                }
//            }
//        }
    )
}