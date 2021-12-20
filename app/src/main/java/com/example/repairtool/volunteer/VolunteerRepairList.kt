package com.example.repairtool.volunteer

import android.print.PrintAttributes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repairtool.repairs.Repair
import com.example.repairtool.repairs.RepairList
import com.example.repairtool.ui.theme.Header
import com.example.repairtool.ui.theme.RepairToolComposeTheme

@Composable
fun RepairListScreen(name: String?) {
    Header(name)
    GetRepairsList(RepairList.repairList)

}

@Composable
private fun GetRepairsList(repairs: List<Repair>) {
    LazyColumn (modifier = Modifier.padding(top = 80.dp)){
        items(repairs) { repair ->
            RepairList(repair)
        }
    }
}

@Composable
private fun RepairList(repair: Repair) {
    Row(
        modifier = Modifier.padding(start = 16.dp)
    ) {
        Text(text = repair.name)
        Text(text = repair.location)
        Text(text = repair.status)
    }
}

//Preview for Android Studio
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RepairToolComposeTheme() {
        GetRepairsList(RepairList.repairList)
    }
}