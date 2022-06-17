package com.kahuis.repairtool.domain.model

import com.google.gson.annotations.SerializedName
import com.kahuis.repairtool.data.remote.dto.ReparationDto
import com.kahuis.repairtool.domain.model.Repair

data class RepairResponse (
    @SerializedName("data")
    var reparations: List<ReparationDto>
)