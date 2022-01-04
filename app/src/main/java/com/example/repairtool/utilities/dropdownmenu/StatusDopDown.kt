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
import com.example.repairtool.utilities.dropdownmenu.items.StatusList

@Composable
fun statusDropdown() : String {
    //Dropdown
    //DropdownMenu variables
    var statusName: String by remember { mutableStateOf(StatusList.statusList[0].toString()) }
    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(top = 16.dp)
    ) {
        Text(text = "Status", color = MaterialTheme.colors.secondary)

        //Actual DropDownMenus
        Row(
            modifier = Modifier
                .clickable {
                    expanded = !expanded
                }
        ) {
            Spacer(modifier = Modifier.width(30.dp))
            Text(text = statusName, color = MaterialTheme.colors.secondary)
            Icon(imageVector = Icons.Filled.ArrowDropDown,
                "DropdownArrow",
                tint = MaterialTheme.colors.secondary)

            DropdownMenu(expanded = expanded, onDismissRequest = {
                expanded = false
            }
            ) {
                StatusList.statusList.forEach { status ->
                    DropdownMenuItem(onClick = {
                        expanded = false
                        statusName = status.status
                    }) {
                        Text(text = status.toString())
                    }
                }
            }
        }
    }
    return statusName
}