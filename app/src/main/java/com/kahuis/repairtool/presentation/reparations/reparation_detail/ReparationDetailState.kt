package com.kahuis.repairtool.presentation.reparations.reparation_detail

import com.kahuis.repairtool.domain.model.ReparationDetail

data class ReparationDetailState(
    val isLoading: Boolean = false,
    val repair: ReparationDetail? = null,
    val error: String = ""
)
