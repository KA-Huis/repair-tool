package com.kahuis.repairtool.common

object Constants {
    private const val mockIsNeeded = true
    val BASE_URL = if(mockIsNeeded) {
        "https://9041b510-37a2-4b32-8bf6-bd2d2a5f7a14.mock.pstmn.io/"
    } else {
        "https://acc-ka.jstlwk.dev"
    }

    const val PARAM_REPAIR_ID = "repairId"
}