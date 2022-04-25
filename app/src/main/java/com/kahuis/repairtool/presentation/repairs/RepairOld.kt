package com.kahuis.repairtool.presentation.repairs

data class RepairOld(
    val id: Int,
    val name: String,
    var building: String,
    var priority: String,
    var description: String,
    var status: String
    )
