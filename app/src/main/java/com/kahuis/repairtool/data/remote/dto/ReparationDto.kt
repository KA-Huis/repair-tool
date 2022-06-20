package com.kahuis.repairtool.data.remote.dto

import com.google.gson.annotations.SerializedName
import com.kahuis.repairtool.domain.model.Reparation

data class ReparationDto(
    @SerializedName("id")
    val id: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("reporter_id")
    val reporter_id: String,

    @SerializedName("priority_type")
    val priority_type: String,

    @SerializedName("space_id")
    val space_id: String,

    @SerializedName("status_type")
    val status_type: String,

    @SerializedName("updated_at")
    val updated_at: String,

    @SerializedName("created_at")
    val created_at: String,

    @SerializedName("deleted_at")
    val deleted_at: String
)

fun ReparationDto.toReparation(): Reparation {
    return Reparation(
        id = id,
        title = title,
        description = description,
        status = status_type,
        priority = priority_type,
        location = space_id
    )
}