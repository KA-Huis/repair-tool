package com.kahuis.repairtool.domain.use_case.get_reparations

import com.kahuis.repairtool.common.Resource
import com.kahuis.repairtool.data.remote.dto.toReparation
import com.kahuis.repairtool.domain.model.Reparation
import com.kahuis.repairtool.domain.repository.ReparationRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetReparationsUseCase @Inject constructor(
    private val repository: ReparationRepository
){
    operator fun invoke(): Flow<Resource<List<Reparation>>> = flow {
        try {
            emit(Resource.Loading<List<Reparation>>())
            val repairs = repository.getReparations().map { it.toReparation() }
            emit(Resource.Success<List<Reparation>>(repairs))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "http exception"))
        } catch (e: IOException){
            emit(Resource.Error<List<Reparation>>("No internet??"))
        }
    }
}