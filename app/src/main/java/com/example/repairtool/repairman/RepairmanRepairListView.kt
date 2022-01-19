package com.example.repairtool.repairman


import android.app.Activity
import android.content.Intent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.repairtool.repairs.Repair
import com.example.repairtool.repairs.RepairList
import com.example.repairtool.ui.theme.RepairToolTheme

@Composable
fun RepairmanView(uName: String?) {
    GetRepairsList(RepairList.repairList, uName) //Creates lazyColumn
}

@Composable
private fun GetRepairsList(repairs: List<Repair>, uName: String?) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 16.dp)
    ) {
        items(repairs) { repair ->
            RepairList(repair, uName)
        }
    }
}

@Composable
private fun RepairList(repair: Repair, uName: String?) {
    RepairToolTheme {
        var isExpanded by remember { mutableStateOf(false) }
        val surfaceColor: Color by animateColorAsState(
            if (isExpanded) MaterialTheme.colors.primary
            else MaterialTheme.colors.primary.copy(alpha = 0.2F),
        )
        Surface(
            color = surfaceColor,
            modifier = Modifier
                .animateContentSize()
                .padding(start = 16.dp, bottom = 6.dp, end = 16.dp)
                .fillMaxWidth(),
            shape = MaterialTheme.shapes.small
        ) {
            Row( //TODO add button
                modifier = Modifier
                    .clickable { isExpanded = !isExpanded }
            ) {
                if (isExpanded) {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowUp,
                        contentDescription = "Show less arrow",
                        modifier = Modifier
                            .size(24.dp)
                            .padding(end = 8.dp),
                        tint = MaterialTheme.colors.secondary
                    )
                } else {
                    Icon(
                        imageVector = Icons.Filled.KeyboardArrowDown,
                        contentDescription = "Show more arrow",
                        modifier = Modifier
                            .size(24.dp)
                            .padding(end = 8.dp),
                        tint = MaterialTheme.colors.secondary
                    )
                }
                Column {
                    Text(
                        text = "Naam reparatie:\n" + repair.name + "\n\n"
                                + "Gebouw: " + repair.building + "\n"
                                + "Prioriteit: " + repair.priority + "\n\n"
                                + "Omschrijving:\n" + repair.description + "\n\n"
                                + "Status: " + repair.status,
                        fontSize = 18.sp,
                        color = MaterialTheme.colors.secondary,
                        maxLines = if (isExpanded) Int.MAX_VALUE else 2,
                        modifier = Modifier.padding(bottom = 16.dp, top = 8.dp)
                    )
                }
                Box(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    val context = LocalContext.current
                    val activity = (LocalContext.current as? Activity)
                    Button(
                        onClick = {
                            val intent = Intent(context, EditRepair::class.java)
                            intent.putExtra("uName", uName)
                            intent.putExtra("id", repair.id)
                            context.startActivity(intent)
                            activity?.finish()
                        },
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterEnd),
                        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.background)
                    ) {
                        Text(text = "Wijzigen", color = MaterialTheme.colors.secondary)


                    }
                }
            }
        }
    }
}

//Preview for Android Studio
@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    RepairToolTheme {
        RepairmanView("Name")
    }
}