package com.example.repairtool.volunteer

import android.graphics.drawable.PaintDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repairtool.R
import com.example.repairtool.repairs.Repair
import com.example.repairtool.repairs.RepairList
import com.example.repairtool.ui.theme.RepairToolComposeTheme
import kotlin.system.exitProcess

@Composable
fun RepairView(name: String?) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(
                    text = "Welkom $name",
                    color = MaterialTheme.colors.secondary) },
                actions = {
                    Text(
                        text = "Afmelden",
                        color = MaterialTheme.colors.secondary,
                        modifier = Modifier
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
            .fillMaxWidth()
            .fillMaxHeight()
            .padding(top = 16.dp)
    ) {
        items(repairs) { repair ->
            RepairList(repair)
        }
    }
}

@Composable
private fun RepairList(repair: Repair) {
    var isExpanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(start = 16.dp, bottom = 8.dp)
            .clickable { isExpanded = !isExpanded }
    ) {
        if(isExpanded) {
            Image(painter = painterResource(R.drawable.ic_showless_icon),
                contentDescription = "Show less arrow",
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 8.dp)
            )
        }
        else {
            Image(painter = painterResource(R.drawable.ic_showmore_icon),
                contentDescription = "Show more arrow",
                modifier = Modifier
                    .size(24.dp)
                    .padding(end = 8.dp)
            )
        }
        Text(text = "Naam reparatie: " + repair.name + "\n"
                + "Locatie: " + repair.location + "\n"
                + "Status: " + repair.status,
            color = MaterialTheme.colors.secondary,
            maxLines = if(isExpanded) Int.MAX_VALUE else 1
        )
    }
}

//Preview for Android Studio
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RepairToolComposeTheme() {
        RepairView(name = "Mitch")
    }
}