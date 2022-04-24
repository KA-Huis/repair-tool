package com.kahuis.repairtool.presentation.repairman

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import com.kahuis.repairtool.presentation.repairs.RepairList.repairList
import com.kahuis.repairtool.presentation.ui.theme.RepairToolTheme
import com.kahuis.repairtool.common.utilities.textfield.multiLineInputTitle
import com.kahuis.repairtool.common.utilities.dropdownmenu.priorityDropdown
import com.kahuis.repairtool.common.utilities.dropdownmenu.statusDropdown

class EditRepair : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val uName = intent.getStringExtra("uName")
            val id = intent.getIntExtra("id", 0)
            RepairToolTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    EditRepair(uName, id)
                }
            }
        }
    }
}

@Composable
private fun EditRepair(uName: String?, id: Int) {
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
                fontStyle = FontStyle.Italic,
                color = MaterialTheme.colors.secondary
            )

            //DropdownMenus
            var priorityName = ""
            Row (
                modifier = Modifier.padding(top = 16.dp)
                    ) {
                Text(text = "Nieuwe ",
                    color = MaterialTheme.colors.secondary
                    )
                priorityName = priorityDropdown()
            }

            Spacer(modifier = Modifier.height(16.dp))
            val statusName = statusDropdown()
            Spacer(modifier = Modifier.height(16.dp))

            //Get extra notes from repairman //TODO not functional
            val repairNotes = multiLineInputTitle("Notities")

            Spacer(modifier = Modifier.height(30.dp))

            //Buttons
            Column(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                val context = LocalContext.current
                val activity = (LocalContext.current as? Activity)
                Button(onClick = {
                    //Push all parameters to function to save it into DB, if button == clicked
                    updateRepair(
                        id,
                        priorityName,
                        statusName
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
                    Text(text = "Annuleren", color = MaterialTheme.colors.secondary)
                }
            }
        }
    }
}

private fun updateRepair(
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