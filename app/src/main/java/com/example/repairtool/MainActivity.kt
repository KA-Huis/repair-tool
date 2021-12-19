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
import com.example.repairtool.utilities.navigation.Screen
import com.example.repairtool.volunteer.RepairListScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RepairToolComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Navigation()
                }
            }
        }
    }
}

@Composable
private fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.LoginScreen.route) {
        composable(route = Screen.LoginScreen.route) {
            LoginScreen(navController = navController)
        }
        composable(
            route = Screen.RepairListScreen.route,
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Mitch"
                    nullable = true
                }
            )
        ) {
            entry ->
            RepairListScreen(name = entry.arguments?.getString("name"))
        }
    }
}

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

        //Get username AND password
        GetUsername()
        GetPassword()

        Spacer(modifier = Modifier.padding(top = 30.dp))

        //Login button AND forgot password button
        Row(//TODO add some design here

        ) {
            //LOGIN
            Button(onClick = {
                navController.navigate(Screen.RepairListScreen.route)
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

@Composable
private fun GetUsername() {
    var text by remember { mutableStateOf("")}

    TextField(
        value = text,
        onValueChange = { text = it},
        label = { Text("Username")},
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = androidx.compose.ui.graphics.Color.Transparent
        ),
        modifier = Modifier.padding(2.dp)
    )
}

@Composable
private fun GetPassword() {
    var text by remember { mutableStateOf("")}

    TextField(
        value = text,
        onValueChange = { text = it},
        label = { Text("Password") },
        visualTransformation = PasswordVisualTransformation(),
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = androidx.compose.ui.graphics.Color.Transparent
        ),
        modifier = Modifier.padding(2.dp)
    )
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