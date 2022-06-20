package com.kahuis.repairtool.presentation.login

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight.Companion.Bold
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.repairtool.R
import com.kahuis.repairtool.common.Constants.userName
import com.kahuis.repairtool.common.navigation.Screen
import com.kahuis.repairtool.common.utilities.textfield.singleLinePasswordLabel
import com.kahuis.repairtool.common.utilities.textfield.singleLineInputLabel

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
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(50.dp, 20.dp, 50.dp, 0.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            userName = singleLineInputLabel("Gebruikersnaam")
            Spacer(modifier = Modifier.height(20.dp))
            val passWord = singleLinePasswordLabel("Wachtwoord")
            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = text,
                color = MaterialTheme.colors.secondary,
                fontWeight = Bold
            )
            Spacer(modifier = Modifier.height(70.dp))

            //LOGIN
            IconButton(
            onClick = {
                if (userName != "")
                    navController.navigate(Screen.ReparationListScreen.route)
                else
                    text = "Vul een gebruikersnaam in."
            },
            modifier = Modifier
                .size(120.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colors.secondary,
                            MaterialTheme.colors.background
                        )
                    ),
                    shape = CircleShape
                )
            ) {
                Text(
                    text = "Login",
                    style = MaterialTheme.typography.h5,
                    fontWeight = Bold,
                    color = Color.White
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

//            //FORGOT PASSWORD
//            Button(
//                elevation = null,
//                colors = ButtonDefaults.buttonColors(
//                    backgroundColor = Color.Transparent
//                ),
//                contentPadding = PaddingValues(),
//                onClick = { text = "Deze functie werkt nog niet." })
//            {
//                Box(
//                    modifier = Modifier
//                        .fillMaxWidth()
//                        .background(
//                            brush = Brush.verticalGradient(
//                                colors = listOf(
//                                    MaterialTheme.colors.secondary,
//                                    MaterialTheme.colors.background
//                                )
//                            ),
//                            shape = CircleShape
//                        )
//                        .padding(horizontal = 16.dp, vertical = 8.dp),
//                    contentAlignment = Alignment.Center
//                ) {
//                    Text(text = "Wachtwoord vergeten", color = Color.White)
//                }
//            }

        }
    }
}