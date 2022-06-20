package com.kahuis.repairtool.domain.model

data class ReparationDetail (
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