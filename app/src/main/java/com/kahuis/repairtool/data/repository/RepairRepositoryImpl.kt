package com.kahuis.repairtool.data.repository

import android.util.Log
import com.kahuis.repairtool.data.remote.dto.ReparationDto
import com.kahuis.repairtool.data.remote.RepairApi
import com.kahuis.repairtool.data.remote.dto.RepairDetailDto
import com.kahuis.repairtool.data.remote.dto.toRepair
import com.kahuis.repairtool.domain.model.Repair
import com.kahuis.repairtool.domain.model.RepairResponse
import com.kahuis.repairtool.domain.repository.RepairRepository
import kotlinx.coroutines.suspendCancellableCoroutine
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

class RepairRepositoryImpl @Inject constructor(
    private val api: RepairApi
) : RepairRepository {

    override suspend fun getReparations(): List<ReparationDto> {
        val reparationList = ArrayList<ReparationDto>()
        if (reparationList.isEmpty()){
            val call = api.getReparationList()
            val repairs = call.await()
            for (reparation in repairs.reparations) {
                reparationList.add(
                    ReparationDto(
                        reparation.id,
                        reparation.title,
                        reparation.description,
                        reparation.reporter_id,
                        reparation.priority_type,
                        reparation.space_id,
                        reparation.status_type,
                        reparation.updated_at,
                        reparation.created_at,
                        reparation.deleted_at
                    )
                )
            }
        }
        return reparationList
    }

    override suspend fun getRepair(repairId: String): RepairDetailDto {
        return api.getRepair(repairId)
    }
}