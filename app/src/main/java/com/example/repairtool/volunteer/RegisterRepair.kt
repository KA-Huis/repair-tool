package com.example.repairtool.volunteer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import com.example.repairtool.Job
import com.example.repairtool.R
import kotlin.system.exitProcess

class RegisterRepair : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_repair)

        var btnLogout: ImageView = findViewById(R.id.iv_logout)
        btnLogout.setOnClickListener {
            finishAffinity()
        }

        var btnSendRepair:Button = findViewById(R.id.btn_send_repair)
        btnSendRepair.setOnClickListener {
            addRepair()
        }
    }

    private fun addRepair() {

    }
}