package com.kahuis.repairtool.data.remote.dto

import com.kahuis.repairtool.domain.model.ReparationDetail

data class ReparationDetailDto(
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

fun ReparationDetailDto.toReparationDetail(): ReparationDetail {
    return ReparationDetail(
        id = id,
        title = title,
        description = description,
        reporter_id = reporter_id,
        priority_type = priority_type,
        space_id = space_id,
        status_type = status_type,
        updated_at = updated_at,
        created_at = created_at,
        deleted_at = deleted_at
    )
}