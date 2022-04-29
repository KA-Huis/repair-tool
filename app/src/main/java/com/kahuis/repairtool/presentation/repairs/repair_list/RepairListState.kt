package com.kahuis.repairtool.presentation.repairs.repair_list

import com.kahuis.repairtool.domain.model.Repair

data class RepairListState(
    val isLoading: Boolean = false,
    val repairs: List<Repair> = emptyList(),
    val error: String = ""
)