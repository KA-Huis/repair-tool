package com.kahuis.repairtool.data.repository

import com.kahuis.repairtool.data.remote.dto.ReparationDto
import com.kahuis.repairtool.data.remote.ReparationApi
import com.kahuis.repairtool.data.remote.dto.ReparationDetailDto
import com.kahuis.repairtool.domain.repository.ReparationRepository
import retrofit2.await
import javax.inject.Inject

class ReparationRepositoryImpl @Inject constructor(
    private val api: ReparationApi
) : ReparationRepository {

    override suspend fun getReparations(): List<ReparationDto> {
        val reparationList = ArrayList<ReparationDto>()
        if (reparationList.isEmpty()){
            val call = api.getReparationList().await()
            for (reparation in call.reparations) {
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

    override suspend fun getRepair(repairId: String): ReparationDetailDto {
        return api.getReparation(repairId)
    }
}