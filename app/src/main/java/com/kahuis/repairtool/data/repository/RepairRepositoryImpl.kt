package com.kahuis.repairtool.data.repository

import android.util.Log
import com.kahuis.repairtool.data.remote.dto.ReparationDto
import com.kahuis.repairtool.data.remote.RepairApi
import com.kahuis.repairtool.data.remote.dto.RepairDetailDto
import com.kahuis.repairtool.domain.modelNew.RepairResponse
import com.kahuis.repairtool.domain.repository.RepairRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RepairRepositoryImpl @Inject constructor(
    private val api: RepairApi
): RepairRepository {
    override suspend fun getReparations(): List<ReparationDto> {

        val list = ArrayList<ReparationDto>()

        val call = api.getReparationList()
        call.enqueue(object: Callback<RepairResponse> {
            override fun onResponse(
                call: Call<RepairResponse>,
                response: Response<RepairResponse>
            ) {
                if (response.code() == 200) {
                    val repairResponse = response.body()!!
                    for (reparation in repairResponse.reparations){
                        list.add(
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
                        //Update GUI
                    }
                    Log.v("1", "LOOP")
                }
            }
            override fun onFailure(call: Call<RepairResponse>, t: Throwable) {

            }
        })
        Log.v("2", "RETURN")
        return list
    }

    override suspend fun getRepair(repairId: String): RepairDetailDto {
        return api.getRepair(repairId)
    }
}