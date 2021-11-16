package com.example.repairtool.volunteer

import android.R.attr
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.repairtool.Job
import com.example.repairtool.JobList
import com.example.repairtool.MainAdapter
import com.example.repairtool.R
import com.example.repairtool.databinding.ActivityVolunteerMainBinding
import android.R.attr.data




class VolunteerMain : AppCompatActivity() {

    var binding: ActivityVolunteerMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Inflate binding
        binding = ActivityVolunteerMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        val adapter = MainAdapter(JobList.jobList)
        binding?.rvVolunteerMain?.adapter = adapter

        //Updating view

        //Creating fields
        var btnRepair:Button = findViewById(R.id.btn_reg_repair)
        var btnLogout:ImageView = findViewById(R.id.iv_logout)

        //CLickOnListeners
        btnRepair.setOnClickListener {
            val intent = Intent(this, RegisterRepair::class.java)
            startActivity(intent)
        }
        btnLogout.setOnClickListener {
            finishAffinity()
        }

        //Actual Code

    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}