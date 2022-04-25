package com.kahuis.repairtool.presentation.repairs

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kahuis.repairtool.common.Resource
import com.kahuis.repairtool.domain.use_case.get_repairs.GetRepairsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class RepairListViewModel @Inject constructor(
    private val getRepairsUseCase: GetRepairsUseCase
) : ViewModel() {
    private val _state = mutableStateOf(RepairListState())
    val state: State<RepairListState> = _state

    init {
        getRepairs()
    }

    private fun getRepairs() {
        getRepairsUseCase().onEach { result ->
            when(result){
                is Resource.Success -> {
                    _state.value = RepairListState(repairs = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = RepairListState(
                        error = result.message ?: "Unexpected error"
                    )
                }
                is Resource.Loading -> {
                    _state.value = RepairListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
