package com.kahuis.repairtool.domain.repository

import com.kahuis.repairtool.data.remote.dto.RepairDetailDto
import com.kahuis.repairtool.data.remote.dto.RepairDto


interface RepairRepository {

    suspend fun getRepairs(): List<RepairDto>
    suspend fun getRepair(repairId: String): RepairDetailDto
}