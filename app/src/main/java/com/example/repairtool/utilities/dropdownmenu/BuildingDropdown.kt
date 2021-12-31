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
import com.example.repairtool.repairs.BuildingList

@Composable
fun buildingDropdown() : String {
    //Dropdown
    //DropdownMenu variables
    var buildingName: String by remember { mutableStateOf(BuildingList.buildingList[0].toString()) }
    var expanded by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .padding(top = 16.dp, bottom = 16.dp)
    ) {
        Text(text = "Gebouw", color = MaterialTheme.colors.secondary)

        //Actual DropDownMenus
        Row(
            modifier = Modifier
                .clickable {
                    expanded = !expanded
                }
        ) {
            Spacer(modifier = Modifier.width(30.dp))
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