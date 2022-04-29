package com.kahuis.repairtool.domain.use_case.get_repair

import com.kahuis.repairtool.common.Resource
import com.kahuis.repairtool.data.remote.dto.toRepair
import com.kahuis.repairtool.data.remote.dto.toRepairDetail
import com.kahuis.repairtool.domain.model.Repair
import com.kahuis.repairtool.domain.model.RepairDetail
import com.kahuis.repairtool.domain.repository.RepairRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetRepairUseCase @Inject constructor(
    private val repository: RepairRepository
){
    operator fun invoke(repairId: String): Flow<Resource<RepairDetail>> = flow {
        try {
            emit(Resource.Loading<RepairDetail>())
            val repair = repository.getRepair(repairId).toRepairDetail()
            emit(Resource.Success<RepairDetail>(repair))
        } catch (e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "http exception"))
        } catch (e: IOException){
            emit(Resource.Error<RepairDetail>("No internet??"))
        }
    }
}