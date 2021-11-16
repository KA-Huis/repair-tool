package com.example.repairtool

object JobList {
    fun addJob(job:Job){
        jobList += job
    }

    var jobList = listOf<Job>(
        Job(1, "Lamp stuk", 1, "Hoofdgebouw", "Lamp", "Geregistreerd"),
        Job(2, "Vloer ligt los", 2, "Kamer 2", "Vloer", "In behandeling"),
        Job(3, "Frietpan stuk", 1, "Hoofdgebouw", "Frietpan", "Wachtend")
    )
}