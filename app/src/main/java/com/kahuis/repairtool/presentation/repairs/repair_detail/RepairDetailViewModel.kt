package com.kahuis.repairtool.presentation.repairs.repair_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kahuis.repairtool.common.Constants
import com.kahuis.repairtool.common.Resource
import com.kahuis.repairtool.domain.use_case.get_repair.GetRepairUseCase
import com.kahuis.repairtool.domain.use_case.get_repairs.GetRepairsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RepairDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetRepairUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(RepairDetailState())
    val state: State<RepairDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_REPAIR_ID)?.let { repairId ->
            getRepair(repairId)
        }
    }

    private fun getRepair(repairId: String) {
        getCoinUseCase(repairId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = RepairDetailState(repair = result.data)
                }
                is Resource.Error -> {
                    _state.value = RepairDetailState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = RepairDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}