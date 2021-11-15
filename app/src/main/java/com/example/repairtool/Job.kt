package com.example.repairtool

data class Job(
    val id:Int,
    val job:String,
    val priority:Int, //TODO enum
    val place:String,
    val neededTool:String, //TODO array of tools
    val status:String //TODO enum
)
