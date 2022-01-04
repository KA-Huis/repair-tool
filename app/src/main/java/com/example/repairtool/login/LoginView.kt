package com.example.repairtool.login

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.repairtool.R
import com.example.repairtool.repairman.RepairmanActivity
import com.example.repairtool.ui.theme.RepairToolTheme
import com.example.repairtool.utilities.textfield.singelLinePasswordLabel
import com.example.repairtool.utilities.textfield.singleLineInputLabel
import com.example.repairtool.volunteer.VolunteerActivity

//Main function to show loginpage
@Composable
fun LoginView() {
    var text by remember { mutableStateOf("") }
    val count = remember { mutableStateOf(0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ) {
        //Login view for app
        Spacer(modifier = Modifier.padding(20.dp))
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "Logo",
            modifier = Modifier
                .size(200.dp)
                .padding(16.dp)
                .clip(shape = CircleShape)
                .clickable {
                    count.value++
                }
        )

        if (count.value == 5)
            text = "Oelala, you touched me"
        else if (count.value > 5) {
            text = ""
            count.value = 0
        }

        //Get username AND password from loginPackage
        val uName = singleLineInputLabel("Gebruikersnaam")
        val pWord = singelLinePasswordLabel("Wachtwoord")

        Spacer(modifier = Modifier.padding(top = 30.dp))

        //Login button AND forgot password button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            //LOGIN
            val context = LocalContext.current
            val activity = (LocalContext.current as? Activity)

            Button(
                onClick = {
                    when (uName.lowercase()) {
                        "vrijwilliger" -> { //TODO this is hardcoded :)
                            val intent = Intent(context, VolunteerActivity::class.java)
                            intent.putExtra("uName",uName)
                            context.startActivity(intent)
                            activity?.finish()
                        }
                        "klusjesman" -> {
                            val intent = Intent(context, RepairmanActivity::class.java)
                            intent.putExtra("uName",uName)
                            context.startActivity(intent)
                            activity?.finish()
                        }
                        else -> text = "Voer gebruikersnaam & wachtwoord in."
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)
            ) {
                Text(text = "Inloggen", color = MaterialTheme.colors.secondary)
            }

            Spacer(modifier = Modifier.padding(2.dp))

            //FORGOT PASSWORD
            Button(
                onClick = {
                    text = "Deze functie werkt nog niet."
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant)
            ) {
                Text(text = "Wachtwoord vergeten", color = MaterialTheme.colors.secondary)
            }
        }
        Spacer(modifier = Modifier.padding(2.dp))
        Text(text = text,
            color = MaterialTheme.colors.secondary,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview
@Composable
private fun DefaultPreview() {
    RepairToolTheme {
        LoginView()
    }
}