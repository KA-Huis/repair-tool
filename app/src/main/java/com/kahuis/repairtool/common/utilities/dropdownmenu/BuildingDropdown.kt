package com.kahuis.repairtool.common.utilities.dropdownmenu

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.kahuis.repairtool.common.utilities.dropdownmenu.items.BuildingList

@Composable
fun buildingDropdown() : String {
    //Dropdown
    //DropdownMenu variables
    var buildingName: String by remember { mutableStateOf(BuildingList.buildingList[0].toString()) }
    var expanded by remember { mutableStateOf(false) }

    Row {
        //Actual DropDownMenus
        Row(
            modifier = Modifier
                .clickable {
                    expanded = !expanded
                }
        ) {
            Text(text = "Gebouw: ", color = MaterialTheme.colors.secondary)
            Text(text = buildingName, color = MaterialTheme.colors.secondary)
            Icon(imageVector = Icons.Filled.ArrowDropDown,
                "DropdownArrow",
                tint = MaterialTheme.colors.secondary)

            DropdownMenu(expanded = expanded, onDismissRequest = {
                expanded = false
            }
            ) {
                BuildingList.buildingList.forEach { building ->
                    DropdownMenuItem(onClick = {
                        expanded = false
                        buildingName = building.name
                    }) {
                        Text(text = building.toString())
                    }
                }
            }
        }
    }
    return buildingName
}