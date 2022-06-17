package com.kahuis.repairtool.data.remote

import com.kahuis.repairtool.data.remote.dto.RepairDetailDto
import com.kahuis.repairtool.data.remote.dto.ReparationDto
import com.kahuis.repairtool.domain.model.RepairResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RepairApi {

    //Get all repairs available
    @GET("/get_repairs")
    fun getReparationList(): Call<RepairResponse>

    //Get one single repair for detailed view
    @GET("/get_repair/{repairId}")
    suspend fun getRepair(@Path("repairId")repairId: String): RepairDetailDto

    //TODO RT #37, Implement API endpoints
    @POST("")
    suspend fun postRepair()
}