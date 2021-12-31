package com.example.repairtool.volunteer

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repairtool.repairs.Repair
import com.example.repairtool.repairs.RepairList.repairList
import com.example.repairtool.ui.theme.RepairToolTheme
import com.example.repairtool.utilities.textfield.multiLineInputTitle
import com.example.repairtool.utilities.textfield.singleLineInputTitle
import androidx.compose.material.Icon
import com.example.repairtool.repairs.PriorityList.priorityList

@Composable
fun AddRepair(uName: String?) {
    RepairToolTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            //Get name of repair
            val repairName = singleLineInputTitle("Naam reparatie")

            //Dropdown
            //DropdownMenu variables
            var priorityName: String by remember { mutableStateOf(priorityList[0].toString()) }
            var expanded by remember { mutableStateOf(false) }

            Row(
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 16.dp)
            ) {
                Text(text = "Prioriteit", color = MaterialTheme.colors.secondary)

                //Actual DropDownMenus
                Row(
                    modifier = Modifier
                        .clickable {
                            expanded = !expanded
                        }
                ) {
                    Spacer(modifier = Modifier.width(30.dp))
                    Text(text = priorityName, color = MaterialTheme.colors.secondary)
                    Icon(imageVector = Icons.Filled.ArrowDropDown,
                        "DropdownArrow",
                        tint = MaterialTheme.colors.secondary)

                    DropdownMenu(expanded = expanded, onDismissRequest = {
                        expanded = false
                    }
                    ) {
                        priorityList.forEach { priority ->
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

            //Get description of repair
            val repairDescription = multiLineInputTitle("Omschrijving reparatie")
            
            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                val context = LocalContext.current
                val activity = (LocalContext.current as? Activity)
                Button(onClick = {
                    //Push all parameters to function to save it into DB, if button == clicked
                    SaveRepair(repairName, priorityName, repairDescription)

                    val intent = Intent(context, RepairActivity::class.java)
                    intent.putExtra("uName",uName)
                    context.startActivity(intent)
                    activity?.finish()
                },
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)
                ) {
                    Text(text = "Opslaan", color = MaterialTheme.colors.secondary)
                }

                Spacer(modifier = Modifier.width(20.dp))

                Button(onClick = {
                    val intent = Intent(context, RepairActivity::class.java)
                    intent.putExtra("uName",uName)
                    context.startActivity(intent)
                    activity?.finish()
                },
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant)
                ) {
                    Text(text = "Annuleren", color = MaterialTheme.colors.secondary)
                }
            }
        }
    }
}

private fun SaveRepair(
    repairName: String,
    priority: String,
    repairDescription: String
) {
    repairList.add(Repair(repairName, priority, repairDescription, "Geregistreerd"))
}

@Preview
@Composable
private fun DefaultPreview() {
    RepairToolTheme {
        AddRepair("Mitch")
    }
}