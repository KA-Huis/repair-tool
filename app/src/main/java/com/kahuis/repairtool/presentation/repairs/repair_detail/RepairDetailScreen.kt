package com.kahuis.repairtool.presentation.repairs.repair_detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontStyle.Companion.Italic
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kahuis.repairtool.common.Constants
import com.kahuis.repairtool.common.navigation.Screen

@Composable
fun RepairDetailScreen(
    navController: NavController,
    viewModel: RepairDetailViewModel = hiltViewModel()
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
                Icon(imageVector = Icons.Filled.Edit, contentDescription = "Edit button")
            }
        },

        content = {
            val state = viewModel.state.value
            Box(modifier = Modifier.fillMaxSize()) {
                state.repair?.let { repair ->
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        contentPadding = PaddingValues(20.dp)
                    ) {
                        item {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = repair.title,
                                    style = MaterialTheme.typography.h3,
                                    modifier = Modifier.weight(8f)
                                )
                                Text(
                                    text = repair.status_type,
                                    color = MaterialTheme.colors.secondary,
                                    fontStyle = Italic,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier
                                        .align(Alignment.CenterVertically)
                                        .weight(2f)
                                )
                            }
                            TextBlockWithTitle("Omschrijving: ", repair.description)
                            TextBlockWithTitle("Prioriteit: ", repair.priority_type)
                        }
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

    )
}

@Composable
private fun TextBlockWithTitle(title: String, description: String) {
    Spacer(modifier = Modifier.height(15.dp))
    Text(
        text = title,
        fontWeight = Bold,
        style = MaterialTheme.typography.body1
    )
    Text(
        text = description,
        fontStyle = Italic,
        style = MaterialTheme.typography.body1
    )
}