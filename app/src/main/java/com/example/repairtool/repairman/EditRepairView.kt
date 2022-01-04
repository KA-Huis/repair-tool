package com.example.repairtool.repairman

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.repairtool.repairs.Repair
import com.example.repairtool.repairs.RepairList.repairList
import com.example.repairtool.ui.theme.RepairToolTheme
import com.example.repairtool.utilities.dropdownmenu.buildingDropdown
import com.example.repairtool.utilities.textfield.multiLineInputTitle
import com.example.repairtool.utilities.textfield.singleLineInputTitle
import com.example.repairtool.utilities.dropdownmenu.priorityDropdown
import com.example.repairtool.utilities.dropdownmenu.statusDropdown
import com.example.repairtool.volunteer.VolunteerActivity

@Composable
fun EditRepair(uName: String, id: Int) {
    RepairToolTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            //Get name of repair
            val repair = repairList.find { it.id == id }
            Text(text = repair?.name + " - " + repair?.building,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colors.secondary,
                fontSize = 18.sp
            )

            Text(text = repair?.description + "\n\n" +
                    "Reparatie is als ${repair?.priority} aangemeld.",
                fontStyle = FontStyle.Italic)

            //DropdownMenus
            var priorityName = ""
            Row {
                Text(text = "Nieuwe ",
                    modifier = Modifier.padding(top = 16.dp)
                    )
                priorityName = priorityDropdown()
            }

            val statusName = statusDropdown()
            Spacer(modifier = Modifier.height(16.dp))

            //Get extra notes from repairman //TODO not functional
            val repairNotes = multiLineInputTitle("Notities")

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
                    UpdateRepair(
                        id,
                        priorityName,
                        statusName
                    )

                    val intent = Intent(context, RepairmanActivity::class.java)
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
                    val intent = Intent(context, RepairmanActivity::class.java)
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

private fun UpdateRepair(
    id: Int,
    priority: String,
    status: String
) {
    repairList.find { it.id == id }?.priority = priority
    repairList.find { it.id == id }?.status = status
}

@Preview (showBackground = true)
@Composable
private fun DefaultPreview() {
    RepairToolTheme {
        EditRepair("Mitch", 1)
    }
}