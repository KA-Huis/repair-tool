package com.example.repairtool.volunteer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.example.repairtool.Job
import com.example.repairtool.JobList
import com.example.repairtool.MainAdapter

import com.example.repairtool.R
import com.example.repairtool.databinding.ActivityVolunteerMainBinding

class RegisterRepair : AppCompatActivity() {

    var binding: ActivityVolunteerMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_repair)

        val btnLogout: ImageView = findViewById(R.id.iv_logout)
        btnLogout.setOnClickListener {
            finishAffinity()
        }

        val btnSendRepair:Button = findViewById(R.id.btn_send_repair)
        btnSendRepair.setOnClickListener {
            addRepair()
            val intent = Intent(this, VolunteerMain::class.java)
            startActivity(intent)
        }
        createPrioritySpinner()
        createPlaceSpinner()

    }

    private fun addRepair() {//TODO make functional
        val shortDescription:TextView = findViewById(R.id.et_short_description)
        val place:Spinner = findViewById(R.id.sp_place)
        var addedJob = Job(
            1, shortDescription.text.toString(),1, place.selectedItem.toString(), "", "Geregistreerd")
        JobList.jobList.add(addedJob)
    }

    private fun createPrioritySpinner() {
        val spinner: Spinner = findViewById(R.id.sp_priority)
        ArrayAdapter.createFromResource(
            this,
            R.array.priority_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    private fun createPlaceSpinner() {
        val spinner: Spinner = findViewById(R.id.sp_place)
        ArrayAdapter.createFromResource(
            this,
            R.array.place_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

}