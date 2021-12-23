package com.example.repairtool

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.repairtool.login.getPassword
import com.example.repairtool.login.getUsername
import com.example.repairtool.ui.theme.RepairToolComposeTheme
import com.example.repairtool.utilities.navigation.LoginToRepairList
import com.example.repairtool.utilities.navigation.Screen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RepairToolComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LoginToRepairList() //Creates and returns navigation from login to repairlist
                }
            }
        }
    }
}

@Composable
fun LoginNav(navController: NavController) {
    LoginView(navController)
}

//Main function to show loginpage
@Composable
private fun LoginView(navController: NavController) {
    var text by remember { mutableStateOf("")}

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
        )

        //Get username AND password from loginPackage
        val uName = getUsername()
        val pWord = getPassword()

        Spacer(modifier = Modifier.padding(top = 30.dp))

        //Login button AND forgot password button
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            //LOGIN
            Button(
                onClick = {
                    if (uName == "Vrijwilliger" && pWord == "welkom") //TODO this is hardcoded
                        navController.navigate(Screen.RepairListScreen.withArgs(uName))
                    else if (uName != "Vrijwilliger" && pWord == "welkom")
                        text = "Gebruikersnaam onjuist"
                    else if (uName == "Vrijwilliger" && pWord != "welkom")
                        text = "Wachtwoord onjuist"
                    else
                        text = "Voer gebruikersnaam & wachtwoord in."
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)
            ) {
                Text(text = "Inloggen", color = MaterialTheme.colors.secondary)
            }

            Spacer(modifier = Modifier.padding(2.dp))

            //FORGOT PASSWORD
            Button(
                onClick = {
                          text = "Deze functie is nog niet functioneel."
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


@Preview(
    showSystemUi = true,
    showBackground = true,
    name = "LightMode"
)
@Preview(
    showBackground = true,
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DarkMode"
)
@Composable
private fun DefaultPreview() {
    RepairToolComposeTheme {
        val navController = rememberNavController()
        LoginView(navController)
    }
}