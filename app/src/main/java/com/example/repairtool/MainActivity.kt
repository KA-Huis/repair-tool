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
import androidx.compose.ui.tooling.preview.Preview
import com.example.repairtool.ui.theme.RepairToolComposeTheme
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.repairtool.login.getPassword
import com.example.repairtool.login.getUsername
import com.example.repairtool.utilities.navigation.LoginToRepairList
import com.example.repairtool.utilities.navigation.Screen
import kotlinx.coroutines.launch

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
        Image(painter = painterResource(R.drawable.ic_login_icon),
            contentDescription = "Login Icon",
            modifier = Modifier
                .size(200.dp)
                .padding(16.dp)
        )

        //Get username AND password from loginPackage
        val uName = getUsername()
        val pWord = getPassword()

        //TODO if uName && pWord checks out, then continue

        Spacer(modifier = Modifier.padding(top = 30.dp))

        //Login button AND forgot password button
        val scaffoldState = rememberScaffoldState()
        val snackbarCoroutineScope = rememberCoroutineScope()
        Scaffold(scaffoldState = scaffoldState) {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                //LOGIN
                Button(onClick = {
                    if (uName != "" || pWord != "")
                        navController.navigate(Screen.RepairListScreen.withArgs(uName))
                    else
                        snackbarCoroutineScope.launch {
                            scaffoldState.snackbarHostState.showSnackbar("No username or password")
                        }
                },
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary,)
                ) {
                    Text(text = "Login", color = MaterialTheme.colors.secondary)
                }

                Spacer(modifier = Modifier.padding(2.dp))

                //FORGOT PASSWORD
                Button(onClick = { /*TODO*/ },
                    colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primaryVariant)
                ) {
                    Text(text = "Forgot password", color = MaterialTheme.colors.secondary)
                }
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