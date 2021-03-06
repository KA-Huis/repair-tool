package com.kahuis.repairtool.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.kahuis.repairtool.common.navigation.Navigation
import com.kahuis.repairtool.presentation.ui.theme.RepairToolTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val retrofit = Retrofit.Builder()
//            .baseUrl(MOCK_API_URL)
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()
//            .create(RepairApi::class.java)
//        val call = retrofit.getReparationList()
//
//        call.enqueue(object : Callback<RepairResponse> {
//            override fun onResponse(call: Call<RepairResponse>, response: Response<RepairResponse>) {
//                if (response.code() == 200) {
//                    val repairResponse = response.body()!!
//                    for( repair in repairResponse.repairs){
//                        Log.v("MainActivity", repair.description)
//                    }
//                }
//            }
//            override fun onFailure(call: Call<RepairResponse>, t: Throwable) {
//            }
//        })
        setContent {
            RepairToolTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Navigation()
                }
            }
        }
    }
}