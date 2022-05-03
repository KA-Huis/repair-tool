package com.kahuis.repairtool.domain.model

data class Repair(

    val id: String,
    val title: String,
    val description: String,
    val location: String,
    val priority: String,
    val status: String

)
