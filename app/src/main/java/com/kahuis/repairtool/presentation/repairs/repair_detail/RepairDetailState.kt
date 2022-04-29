package com.kahuis.repairtool.presentation.repairs.repair_detail

import com.kahuis.repairtool.domain.model.Repair
import com.kahuis.repairtool.domain.model.RepairDetail

data class RepairDetailState(
    val isLoading: Boolean = false,
    val repair: RepairDetail? = null,
    val error: String = ""
)
