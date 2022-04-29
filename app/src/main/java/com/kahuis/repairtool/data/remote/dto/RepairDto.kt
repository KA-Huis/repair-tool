package com.kahuis.repairtool.data.remote.dto

import com.kahuis.repairtool.domain.model.Repair

data class RepairDto(
    val description: String,
    val priority: String,
    val status: String,
    val title: String,
    val location: String
)

fun RepairDto.toRepair(): Repair {
    return Repair(
        title = title,
        description = description,
        priority = priority,
        status = status
    )
}