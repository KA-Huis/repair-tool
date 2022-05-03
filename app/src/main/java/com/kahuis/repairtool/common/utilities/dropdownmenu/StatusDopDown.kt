package com.kahuis.repairtool.common.utilities.dropdownmenu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.kahuis.repairtool.common.utilities.dropdownmenu.items.StatusList

@Composable
fun statusDropdown() : String {
    //Dropdown
    //DropdownMenu variables
    var statusName: String by remember { mutableStateOf(StatusList.statusList[0].toString()) }
    var expanded by remember { mutableStateOf(false) }

    Row {
        //Actual DropDownMenus
        Row(
            modifier = Modifier
                .clickable {
                    expanded = !expanded
                }
        ) {
            Text(text = "Status: ", color = MaterialTheme.colors.secondary)
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