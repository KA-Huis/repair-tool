package com.kahuis.repairtool.data.dto

data class Body(
    val formdata: List<Formdata>,
    val mode: String,
    val options: Options
)