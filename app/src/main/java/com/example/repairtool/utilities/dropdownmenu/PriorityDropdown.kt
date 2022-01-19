package com.example.repairtool.utilities.dropdownmenu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.repairtool.utilities.dropdownmenu.items.PriorityList

@Composable
fun priorityDropdown() : String {
    //Dropdown
    //DropdownMenu variables
    var priorityName: String by remember { mutableStateOf(PriorityList.priorityList[0].toString()) }
    var expanded by remember { mutableStateOf(false) }

    Row {
        //Actual DropDownMenus
        Row(
            modifier = Modifier
                .clickable {
                    expanded = !expanded
                }
        ) {
            Text(text = "Prioriteit: ", color = MaterialTheme.colors.secondary)
            Text(text = priorityName, color = MaterialTheme.colors.secondary)
            Icon(imageVector = Icons.Filled.ArrowDropDown,
                "DropdownArrow",
                tint = MaterialTheme.colors.secondary)

            DropdownMenu(expanded = expanded, onDismissRequest = {
                expanded = false
            }
            ) {
                PriorityList.priorityList.forEach { priority ->
                    DropdownMenuItem(onClick = {
                        expanded = false
                        priorityName = priority.priority
                    }) {
                        Text(text = priority.toString())
                    }
                }
            }
        }
    }
    return priorityName
}