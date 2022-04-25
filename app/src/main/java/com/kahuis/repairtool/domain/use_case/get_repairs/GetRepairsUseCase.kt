package com.kahuis.repairtool.domain.use_case.get_repairs

import com.kahuis.repairtool.common.Resource
import com.kahuis.repairtool.data.dto.toRepair
import com.kahuis.repairtool.domain.model.Repair
import com.kahuis.repairtool.domain.repository.RepairRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetRepairsUseCase @Inject constructor(
    private val repository: RepairRepository
){
    operator fun invoke(): Flow<Resource<List<Repair>>> = flow {
        try {
            emit(Resource.Loading())
            val repairs = repository.getRepairs().map { it.toRepair() }
            emit(Resource.Success(repairs))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "http exception"))
        } catch (e: IOException){
            emit(Resource.Error("No internet??"))
        }
    }
}