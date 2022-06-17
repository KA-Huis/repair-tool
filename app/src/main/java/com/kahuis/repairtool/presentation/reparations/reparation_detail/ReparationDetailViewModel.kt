package com.kahuis.repairtool.presentation.reparations.reparation_detail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kahuis.repairtool.common.Constants
import com.kahuis.repairtool.common.Resource
import com.kahuis.repairtool.domain.use_case.get_reparation.GetReparationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ReparationDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetReparationUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(ReparationDetailState())
    val state: State<ReparationDetailState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_REPAIR_ID)?.let { repairId ->
            getRepair(repairId)
        }
    }

    private fun getRepair(repairId: String) {
        getCoinUseCase(repairId).onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = ReparationDetailState(repair = result.data)
                }
                is Resource.Error -> {
                    _state.value = ReparationDetailState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = ReparationDetailState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}