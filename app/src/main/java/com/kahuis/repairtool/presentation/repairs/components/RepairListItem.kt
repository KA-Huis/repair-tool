package com.kahuis.repairtool.presentation.repairs.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kahuis.repairtool.domain.model.Repair

@Composable
fun RepairListItem(
    repair: Repair,
    onItemClick: (Repair) -> Unit
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(repair) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
            ){
        Text(
            text = "${repair.title}, ${repair.description}"
        )
    }
}