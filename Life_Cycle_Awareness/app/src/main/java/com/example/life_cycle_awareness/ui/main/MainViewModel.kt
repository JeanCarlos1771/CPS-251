package com.example.life_cycle_awareness.ui.main

import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    var status = arrayListOf<String>()
    var lifeCycleStatus = ""

    fun storeStatus(cycle: String){
        status.add(cycle.toString())
    }


}