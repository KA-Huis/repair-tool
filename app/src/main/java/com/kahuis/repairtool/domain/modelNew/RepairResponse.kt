package com.kahuis.repairtool.domain.modelNew

import com.google.gson.annotations.SerializedName
import com.kahuis.repairtool.data.remote.dto.ReparationDto

class RepairResponse {
    @SerializedName("data")
    var reparations = ArrayList<ReparationDto>()
}