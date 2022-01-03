package com.example.repairtool.volunteer

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repairtool.repairs.Repair
import com.example.repairtool.repairs.RepairList.repairList
import com.example.repairtool.ui.theme.RepairToolTheme
import com.example.repairtool.utilities.dropdownmenu.buildingDropdown
import com.example.repairtool.utilities.textfield.multiLineInputTitle
import com.example.repairtool.utilities.textfield.singleLineInputTitle
import com.example.repairtool.utilities.dropdownmenu.priorityDropdown

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

            //DropdownMenus
            val priorityName = priorityDropdown()
            val buildingName = buildingDropdown()

            //Get description of repair
            val repairDescription = multiLineInputTitle("Omschrijving reparatie")
            
            Spacer(modifier = Modifier.height(30.dp))

            //Buttons
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
                    SaveRepair(
                        repairName,
                        priorityName,
                        buildingName,
                        repairDescription
                    )

                    val intent = Intent(context, VolunteerActivity::class.java)
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
                    val intent = Intent(context, VolunteerActivity::class.java)
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
    building: String,
    repairDescription: String
) {
    repairList.add(Repair(repairName, building ,priority, repairDescription,"Geregistreerd"))
}

@Preview (showBackground = true)
@Composable
private fun DefaultPreview() {
    RepairToolTheme {
        AddRepair("Mitch")
    }
}