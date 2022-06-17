package com.kahuis.repairtool.data.remote

import com.kahuis.repairtool.common.Constants.editReparation
import com.kahuis.repairtool.common.Constants.getReparationDetail
import com.kahuis.repairtool.common.Constants.getReparationList
import com.kahuis.repairtool.common.Constants.postReparationRequest
import com.kahuis.repairtool.data.remote.dto.ReparationDetailDto
import com.kahuis.repairtool.domain.model.ReparationResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ReparationApi {

    //Get all repairs available
    @GET(getReparationList)
    fun getReparationList(): Call<ReparationResponse>

    //Get one single repair for detailed view
    @GET(getReparationDetail)
    suspend fun getReparation(@Path("repairId")repairId: String): ReparationDetailDto

    //TODO RT #37, Implement API endpoints
    //Post reparationsRequest
    @POST(postReparationRequest)
    suspend fun postReparationRequest()

    //Edit existing reparation
    @POST(editReparation)
    suspend fun editReparation()
}