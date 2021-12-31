package com.example.repairtool.volunteer

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repairtool.R
import com.example.repairtool.repairs.Repair
import com.example.repairtool.repairs.RepairList
import com.example.repairtool.ui.theme.RepairToolTheme

@Composable
fun RepairView() {
    GetRepairsList(RepairList.repairList) //Creates lazyColumn
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
    RepairToolTheme {
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
            Text(text = "Naam reparatie: " + repair.name + "\n\n"
                    + "Prioriteit: " + repair.priority + "\n\n"
                    + "Omschrijving: " + repair.description + "\n\n"
                    + "Status: " + repair.status,
                color = MaterialTheme.colors.secondary,
                maxLines = if(isExpanded) Int.MAX_VALUE else 1
            )
        }
    }
}

//Preview for Android Studio
@Preview(showBackground = true)
@Composable
private fun DefaultPreview() {
    RepairToolTheme {
        RepairView()
    }
}