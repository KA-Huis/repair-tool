package com.kahuis.repairtool.domain.repository

import com.kahuis.repairtool.data.remote.dto.ReparationDetailDto
import com.kahuis.repairtool.data.remote.dto.ReparationDto


interface ReparationRepository {

    suspend fun getReparations(): List<ReparationDto>
    suspend fun getRepair(repairId: String): ReparationDetailDto
}