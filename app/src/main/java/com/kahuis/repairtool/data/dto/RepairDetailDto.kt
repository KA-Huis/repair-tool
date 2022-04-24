package com.kahuis.repairtool.data.dto

data class RepairDetailDto(
    val event: List<Event>,
    val info: Info,
    val item: List<Item>,
    val variable: List<Variable>
)