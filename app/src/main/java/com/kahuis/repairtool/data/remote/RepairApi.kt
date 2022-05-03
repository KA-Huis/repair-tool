package com.kahuis.repairtool.data.remote

import com.kahuis.repairtool.data.remote.dto.RepairDetailDto
import com.kahuis.repairtool.data.remote.dto.RepairDto
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RepairApi {

    //Get all repairs available
    @GET("/get_repairs/")
    suspend fun getRepairs(): List<RepairDto>

    //Get one single repair for detailed view
    @GET("/get_repair/{repairId}")
    suspend fun getRepair(@Path("repairId")repairId: String): RepairDetailDto

    //TODO URL!
    @POST("")
    suspend fun postRepair()
}