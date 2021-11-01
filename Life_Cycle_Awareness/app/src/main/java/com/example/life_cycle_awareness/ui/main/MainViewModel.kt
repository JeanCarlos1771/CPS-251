package com.example.life_cycle_awareness.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel
    companion object{
        private var message : MutableLiveData<String> = MutableLiveData()

        private var state = ""
        fun setEvent(msg:String) {
            state += msg
            message.value = state
        }
    }
    fun getMsg():MutableLiveData<String>{
        return message
    }
}