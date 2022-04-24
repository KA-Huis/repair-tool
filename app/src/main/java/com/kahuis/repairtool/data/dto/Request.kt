package com.kahuis.repairtool.data.dto

data class Request(
    val body: Body,
    val header: List<Header>,
    val method: String,
    val url: Url
)