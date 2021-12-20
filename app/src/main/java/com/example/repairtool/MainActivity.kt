package com.example.repairtool

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.repairtool.ui.theme.RepairToolComposeTheme
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.repairtool.login.getPassword
import com.example.repairtool.login.getUsername
import com.example.repairtool.utilities.navigation.LoginNavigation
import com.example.repairtool.utilities.navigation.Screen
import com.example.repairtool.volunteer.RepairListScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RepairToolComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    LoginNavigation() //Creates navigation from login to repairlist
                }
            }
        }
    }
}

@Composable
fun LoginNav(navController: NavController) {
    LoginScreen(navController)
}

//Main function to show loginpage
@Composable
private fun LoginScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Login view for app
        Spacer(modifier = Modifier.padding(20.dp))
        Image(painter = painterResource(R.drawable.login_icon),
            contentDescription = "Login Icon",
            modifier = Modifier
                .size(200.dp)
                .padding(16.dp)
        )

        //Get username AND password from loginPackage
        val uName = getUsername()
        val pWord = getPassword()

        //TODO uName && pWord checks out, then continue

        Spacer(modifier = Modifier.padding(top = 30.dp))

        //Login button AND forgot password button
        Row(//TODO add some design here

        ) {
            //LOGIN
            Button(onClick = {
                navController.navigate(Screen.RepairListScreen.withArgs(uName))
            },
                colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)
            ) {
                Text(text = "Login")
            }

            Spacer(modifier = Modifier.padding(2.dp))

            //FORGOT PASSWORD
            Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant)
            ) {
                Text(text = "Forgot password")
            }
        }
    }
}

@Preview(
    showBackground = true,
    name = "LightMode"
)
@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "DarkMode"
)
@Composable
private fun DefaultPreview() {
    RepairToolComposeTheme {
//        LoginScreen()
    }
}