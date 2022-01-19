package com.example.repairtool.repairman

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.repairtool.MainActivity
import com.example.repairtool.ui.theme.RepairToolTheme

class RepairmanActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val uName = intent.getStringExtra("uName")

            RepairToolTheme {
                Scaffold(
                    topBar = { //TopBar creates welcome message and logout option
                        TopAppBar(
                            title = { Text(
                                text = "Welkom $uName",
                                color = MaterialTheme.colors.secondary) },
                            actions = {
                                val context = LocalContext.current
                                val activity = (LocalContext.current as? Activity)
                                Text(
                                    text = "Afmelden",
                                    color = MaterialTheme.colors.secondary,
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .clickable(onClick = {
                                            val intent = Intent(context, MainActivity::class.java)
                                            activity?.startActivity(intent)
                                            activity?.finish()
                                        })
                                )
                            },
                            backgroundColor = MaterialTheme.colors.primary
                        )
                    },
                ) {
                    RepairmanView(uName)
                }
            }
        }
    }
}