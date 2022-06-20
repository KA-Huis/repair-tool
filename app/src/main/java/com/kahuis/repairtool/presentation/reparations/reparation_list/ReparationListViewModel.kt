package com.kahuis.repairtool.presentation.reparations.reparation_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kahuis.repairtool.common.Resource
import com.kahuis.repairtool.domain.use_case.get_reparations.GetReparationsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class ReparationListViewModel @Inject constructor(
    private val getRepairsUseCase: GetReparationsUseCase
) : ViewModel() {
    private val _state = mutableStateOf(ReparationListState())
    val state: State<ReparationListState> = _state

    init {
        getRepairs()
    }

    private fun getRepairs() {
        getRepairsUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = ReparationListState(repairs = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = ReparationListState(
                        error = result.message ?: "Unexpected error"
                    )
                }
                is Resource.Loading -> {
                    _state.value = ReparationListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
