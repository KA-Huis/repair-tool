package com.example.repairtool

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.repairtool.volunteer.VolunteerMain

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLogin:Button = findViewById(R.id.btn_login)
        val etUName:EditText = findViewById(R.id.et_uname)
        val etPassword:EditText = findViewById(R.id.et_password)

        btnLogin.setOnClickListener {
//            if(etUName.text.isEmpty()&&etPassword.text.isEmpty()) {
//                Toast.makeText(this, "No username or password entered!", Toast.LENGTH_SHORT).show()
//            }else{
                val intent = Intent(this, VolunteerMain::class.java)
                startActivity(intent)
                finish()
//            }
        }
    }
}