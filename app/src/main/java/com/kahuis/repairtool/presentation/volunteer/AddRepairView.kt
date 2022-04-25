package com.kahuis.repairtool.presentation.volunteer

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.kahuis.repairtool.common.utilities.dropdownmenu.buildingDropdown
import com.kahuis.repairtool.common.utilities.dropdownmenu.priorityDropdown
import com.kahuis.repairtool.common.utilities.textfield.multiLineInputTitle
import com.kahuis.repairtool.common.utilities.textfield.singleLineInputTitle
import com.kahuis.repairtool.presentation.repairman.RepairmanActivity
import com.kahuis.repairtool.presentation.repairs.RepairOld
import com.kahuis.repairtool.presentation.repairs.RepairList.repairList
import com.kahuis.repairtool.presentation.ui.theme.RepairToolTheme

@Composable
fun AddRepair(uName: String?) {
    RepairToolTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {
            //Get name of repair
            val repairName = singleLineInputTitle("Naam reparatie")

            //DropdownMenus
            Spacer(modifier = Modifier.height(16.dp))
            val priorityName = priorityDropdown()
            Spacer(modifier = Modifier.height(16.dp))
            val buildingName = buildingDropdown()
            Spacer(modifier = Modifier.height(16.dp))

            //Get description of repair
            val repairDescription = multiLineInputTitle("Omschrijving reparatie")
            
            Spacer(modifier = Modifier.height(32.dp))

            //Buttons
            Column {
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
                    val intent = Intent(context, RepairmanActivity::class.java)
                    intent.putExtra("uName",uName)
                    context.startActivity(intent)
                    activity?.finish()
                },
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Opslaan", color = MaterialTheme.colors.secondary)
                }

                Spacer(modifier = Modifier.height(8.dp))

                Button(onClick = {
                    val intent = Intent(context, RepairmanActivity::class.java)
                    intent.putExtra("uName",uName)
                    context.startActivity(intent)
                    activity?.finish()
                },
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Annuleren", color = MaterialTheme.colors.secondaryVariant)
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
    repairList.add(RepairOld(4, repairName, building ,priority, repairDescription,"Geregistreerd"))
}

@Preview (showBackground = true)
@Composable
private fun DefaultPreview() {
    RepairToolTheme {
        AddRepair("Mitch")
    }
}