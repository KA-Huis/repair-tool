package com.example.repairtool.repairs

object RepairList {
    var repairList = mutableListOf<Repair>(
        Repair("Repair 1", "Main building", "Registered"),
        Repair("Repair 2", "Office","Registered"),
        Repair("Repair 3", "Toilets", "Pending")
    )
}