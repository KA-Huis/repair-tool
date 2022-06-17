package com.kahuis.repairtool.presentation.reparations.reparation_detail

import androidx.compose.foundation.background
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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
    viewModel: ReparationDetailViewModel = hiltViewModel()
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
                        navController.navigate(Screen.ReparationListScreen.route) {
                            popUpTo(Screen.ReparationListScreen.route) {
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
                onClick = { /*TODO*/ },
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
                    imageVector = Icons.Filled.Edit,
                    contentDescription = "Edit button",
                    tint = Color.White
                )
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
                                    color = MaterialTheme.colors.primary,
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
                            TextBlockWithTitle("Locatie", repair.space_id)
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
        color = MaterialTheme.colors.primary,
        style = MaterialTheme.typography.body1
    )
    Text(
        text = description,
        fontStyle = Italic,
        color = MaterialTheme.colors.primary,
        style = MaterialTheme.typography.body1
    )
}