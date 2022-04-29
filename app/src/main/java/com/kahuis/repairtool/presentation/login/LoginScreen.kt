package com.kahuis.repairtool.presentation.login

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.repairtool.R
import com.kahuis.repairtool.common.Constants.uName
import com.kahuis.repairtool.common.utilities.textfield.singelLinePasswordLabel
import com.kahuis.repairtool.common.utilities.textfield.singleLineInputLabel
import com.kahuis.repairtool.common.utilities.navigation.Screen

//Main function to show loginpage
@Composable
fun LoginScreen(
    navController: NavController
) {
    var text by remember { mutableStateOf("") }
    val count = remember { mutableStateOf(0) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
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
        uName = singleLineInputLabel("Gebruikersnaam")
        Spacer(modifier = Modifier.padding(8.dp))
        val pWord = singelLinePasswordLabel("Wachtwoord")

        Spacer(modifier = Modifier.padding(top = 30.dp))

        //Login button AND forgot password button
        /*
        Op dit moment moet de navigatie en code die hier voor gebruikt wordt nog gemaakt worden.
        Inloggen kan door op de knop 'inloggen' te klikken zonder username of wachtwoord te gebruiken.

        Dit is bij wijze van test even gedaan om 1 view te maken (die van de klusjesman)

        TODO navigatie zo maken dat username en wachtwoord weer nodig zijn
         */
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            //LOGIN
            Button(
                onClick = {
                    navController.navigate(Screen.RepairListScreen.withArgs(uName))
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Inloggen", color = MaterialTheme.colors.primary)
            }

            Spacer(modifier = Modifier.height(8.dp))

            //FORGOT PASSWORD
            Button(
                onClick = {
                    text = "Deze functie werkt nog niet."
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.secondary),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Wachtwoord vergeten", color = MaterialTheme.colors.primary)
            }
        }
        Spacer(modifier = Modifier.padding(2.dp))
        Text(text = text,
            color = MaterialTheme.colors.secondary,
            fontWeight = FontWeight.Bold
        )
    }
}