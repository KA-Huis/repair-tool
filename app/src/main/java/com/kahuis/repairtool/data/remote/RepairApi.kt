package com.kahuis.repairtool.data.remote

import com.kahuis.repairtool.data.dto.RepairDto
import retrofit2.http.GET
import retrofit2.http.POST

interface RepairApi {

    @GET("/api/v1/reparation_request")
    suspend fun getRepairs(): List<RepairDto>

    //TODO URL!
    @POST("")
    suspend fun postRepair()
}