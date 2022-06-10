package com.kahuis.repairtool.domain.modelNew

import com.google.gson.annotations.SerializedName

class RepairNew(
    @SerializedName("id")
    val id: String,

    @SerializedName("title")
    val title: String,

    @SerializedName("description")
    val description: String,

    @SerializedName("space_id")
    val location: String,

    @SerializedName("priority_type")
    val priority: String,

    @SerializedName("status_type")
    val status: String
)
