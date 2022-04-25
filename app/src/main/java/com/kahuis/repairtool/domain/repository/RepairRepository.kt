package com.kahuis.repairtool.domain.repository

import com.kahuis.repairtool.data.dto.RepairDto

/*
This class is also for testing purposes, it's a mock for the API so you don't have to actually use the API.
 */

interface RepairRepository {

    suspend fun getRepairs(): List<RepairDto>
}