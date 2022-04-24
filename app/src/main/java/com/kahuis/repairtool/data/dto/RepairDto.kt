package com.kahuis.repairtool.data.dto

import com.kahuis.repairtool.domain.model.Repair
import java.sql.Date

data class RepairDto(
    val created_at: Date,
    val description: String,
    val materials: String,
    val priority: String,
    val reporter: String,
    val status: String,
    val title: String,
    val updated_at: Date,
    val uuid: Int
)

fun RepairDto.toRepair(): Repair {
    return Repair(
        title = title,
        description = description,
        priority = priority,
        status = status,
        materials = materials
    )
}