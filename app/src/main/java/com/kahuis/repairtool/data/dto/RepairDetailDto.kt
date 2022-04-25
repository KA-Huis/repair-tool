package com.kahuis.repairtool.data.dto

/*
TODO Deze klasse moet herzien worden als de juiste API structuur bekend is. Alle andere klassen moeten ook worden herzien daarna.
 */

data class RepairDetailDto(
    val event: List<Event>,
    val info: Info,
    val item: List<Item>,
    val variable: List<Variable>
)