package com.example.repairtool.volunteer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repairtool.repairs.Repair
import com.example.repairtool.repairs.RepairList
//import com.example.repairtool.ui.theme.Header
import com.example.repairtool.ui.theme.RepairToolComposeTheme
import kotlin.system.exitProcess

@Composable
fun Header(name: String?) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Welkom $name") },
                actions = {
                    Text(
                        text = "Afmelden",
                        Modifier
                            .padding(16.dp)
                            .clickable(onClick = {
                                exitProcess(0)
                            })
                    )
                },
                backgroundColor = MaterialTheme.colors.primary
            )
        }
    ) {
        GetRepairsList(RepairList.repairList) //Creates lazyColumn
    }
}

@Composable
private fun GetRepairsList(repairs: List<Repair>) {
    LazyColumn(
        modifier = Modifier
//        .padding(top = 80.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        items(repairs) { repair ->
            RepairList(repair)
        }
    }
}

@Composable
private fun RepairList(repair: Repair) {
    Row(
        modifier = Modifier
            .padding(start = 16.dp)
    ) {
        Text(text = repair.name, color = MaterialTheme.colors.secondary)
        Text(text = repair.location, color = MaterialTheme.colors.secondary)
        Text(text = repair.status, color = MaterialTheme.colors.secondary)
    }
}

//Preview for Android Studio
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RepairToolComposeTheme() {
        Header(name = "Mitch")
    }
}