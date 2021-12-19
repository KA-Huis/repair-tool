package com.example.repairtool

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Color
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.example.repairtool.login.Login
import com.example.repairtool.ui.theme.RepairToolComposeTheme
import com.google.android.material.textfield.TextInputEditText
import androidx.compose.ui.unit.dp as dp1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RepairToolComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Layout()
                    if (Login("username", "password"))
                        //TODO do stuff
                        print("Hi!")
                    //else if password forgotten, do stuff
                    //else, username / password is incorrect
                }
            }
        }
    }
}
@Composable
private fun Layout(){
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //Login view for app
        Spacer(modifier = Modifier.padding(20.dp1))
        Image(painter = painterResource(R.drawable.login_icon),
            contentDescription = "Login Icon",
            modifier = Modifier
                .size(200.dp1)
                .padding(16.dp1)
        )

        //Get username AND password
        GetUsername()
        GetPassword()
        
        Spacer(modifier = Modifier.padding(top = 30.dp1))
        
        //Login button AND forgot password button
        Row(
            
        ) {
            Button(onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary)
            ) {
                Text(text = "Login")
            }
            
            Spacer(modifier = Modifier.padding(2.dp1))
            
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
        modifier = Modifier.padding(2.dp1)
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
        modifier = Modifier.padding(2.dp1)
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
        Layout()
//        Test("Android")
    }
}