package com.example.repairtool.volunteer

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.repairtool.repairs.Repair
import com.example.repairtool.repairs.RepairList
import com.example.repairtool.ui.theme.RepairToolComposeTheme

@Composable
fun RepairListScreen(name: String?) {
    GetRepairsList(RepairList.repairList)
}

@Composable
private fun GetRepairsList(repairs: List<Repair>) {
    LazyColumn {
        items(repairs) { repair ->
            ShowRepairList(repair)
        }
    }
}


@Composable
private fun ShowRepairList(repair: Repair) {
    Row() {
        Text(text = repair.name)
        Text(text = repair.location)
        Text(text = repair.status)
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RepairToolComposeTheme() {
        GetRepairsList(RepairList.repairList)
    }
}