package com.kahuis.repairtool.presentation.reparations.reparation_list

import com.kahuis.repairtool.domain.model.Reparation

data class ReparationListState(
    val isLoading: Boolean = false,
    val repairs: List<Reparation> = emptyList(),
    val error: String = ""
)
