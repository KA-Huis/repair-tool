package com.example.repairtool.volunteer

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
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

            //Get description of repair
            val repairDescription = multiLineInputTitle("Omschrijving reparatie")

            //Push all parameters to function to save it into DB, if button == clicked
            val context = LocalContext.current
            val activity = (LocalContext.current as? Activity)
            Button(onClick = {
                SaveRepair(repairName, repairDescription)
                val intent = Intent(context, RepairActivity::class.java)
                intent.putExtra("uName",uName)
                context.startActivity(intent)
                activity?.finish()
            }) {

            }
        }
    }
}

private fun SaveRepair(
    repairName: String,
    repairDescription: String
) {
    repairList.add(Repair(repairName, "testLocation", "testStatus"))
}

@Preview
@Composable
private fun DefaultPreview() {
    RepairToolTheme {
        AddRepair("Mitch")
    }
}