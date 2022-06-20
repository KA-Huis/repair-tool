package com.kahuis.repairtool.domain.use_case.get_reparation

import com.kahuis.repairtool.common.Resource
import com.kahuis.repairtool.data.remote.dto.toReparationDetail
import com.kahuis.repairtool.domain.model.ReparationDetail
import com.kahuis.repairtool.domain.repository.ReparationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetReparationUseCase @Inject constructor(
    private val repository: ReparationRepository
){
    operator fun invoke(repairId: String): Flow<Resource<ReparationDetail>> = flow {
        try {
            emit(Resource.Loading<ReparationDetail>())
            val repair = repository.getRepair(repairId).toReparationDetail()
            emit(Resource.Success<ReparationDetail>(repair))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "http exception"))
        } catch (e: IOException){
            emit(Resource.Error<ReparationDetail>("No internet??"))
        }
    }
}