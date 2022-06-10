package com.kahuis.repairtool.domain.repository

import com.kahuis.repairtool.data.remote.dto.RepairDetailDto
import com.kahuis.repairtool.data.remote.dto.ReparationDto


interface RepairRepository {

    suspend fun getReparations(): List<ReparationDto>
    suspend fun getRepair(repairId: String): RepairDetailDto
}