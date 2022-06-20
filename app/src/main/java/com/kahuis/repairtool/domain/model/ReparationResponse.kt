package com.kahuis.repairtool.domain.model

import com.google.gson.annotations.SerializedName
import com.kahuis.repairtool.data.remote.dto.ReparationDto

data class ReparationResponse (
    @SerializedName("data")
    var reparations: List<ReparationDto>
)