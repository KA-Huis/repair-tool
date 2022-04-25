package com.kahuis.repairtool.domain.model

import com.kahuis.repairtool.data.dto.Info
import com.kahuis.repairtool.data.dto.Item
import com.kahuis.repairtool.data.dto.RepairDetailDto

data class RepairDetail(
    val item: List<Item>,
    val info: Info
)

fun RepairDetailDto.toRepairDetail():RepairDetail {
    return RepairDetail(
        item = item,
        info = info
    )
}