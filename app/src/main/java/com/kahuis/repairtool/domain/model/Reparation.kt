package com.kahuis.repairtool.domain.model

data class Reparation(

    val id: String,
    val title: String,
    val description: String,
    val location: String,
    val priority: String,
    val status: String

)
