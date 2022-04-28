package com.kahuis.repairtool.data.remote

import com.kahuis.repairtool.data.dto.RepairDto
import retrofit2.http.GET
import retrofit2.http.POST

interface RepairApi {

    @GET("/get_repair")
    suspend fun getRepairs(): List<RepairDto>

    //TODO URL!
    @POST("")
    suspend fun postRepair()
}