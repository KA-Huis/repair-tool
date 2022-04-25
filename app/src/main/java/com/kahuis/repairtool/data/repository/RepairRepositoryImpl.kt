package com.kahuis.repairtool.data.repository

import com.kahuis.repairtool.data.dto.RepairDto
import com.kahuis.repairtool.data.remote.RepairApi
import com.kahuis.repairtool.domain.repository.RepairRepository
import javax.inject.Inject

class RepairRepositoryImpl @Inject constructor(
    private val api: RepairApi
): RepairRepository {
    override suspend fun getRepairs(): List<RepairDto> {
        return api.getRepairs()
    }
}