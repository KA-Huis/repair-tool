package com.kahuis.repairtool.data.remote.dto

import com.kahuis.repairtool.domain.model.Repair

data class RepairDto(
    val id: String,
    val title: String,
    val description: String,
    val reporter_id: String,
    val priority_type: String,
    val space_id: String,
    val status_type: String,
    val updated_at: String,
    val created_at: String,
    val deleted_at: String
)

fun RepairDto.toRepair(): Repair {
    return Repair(
        id = id,
        title = title,
        description = description,
        status = status_type,
        priority = priority_type,
        location = space_id
    )
}