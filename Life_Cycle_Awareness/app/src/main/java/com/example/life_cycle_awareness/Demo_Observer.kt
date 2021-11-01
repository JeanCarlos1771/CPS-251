package com.example.life_cycle_awareness

import android.util.Log
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import com.example.life_cycle_awareness.ui.main.MainViewModel
import java.text.SimpleDateFormat
import java.util.*


class Demo_Observer: LifecycleObserver{

    private var viewModel = MainViewModel
    private var time = ""


    private val LOG_TAG = "DemoObserver"

    private fun getTime() {
        val sdf = SimpleDateFormat("hh:mm:ss.SSSS")
        val currentDate = sdf.format(Date())

        time = currentDate.toString()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.i(LOG_TAG,"on_Resume ")
        getTime()
        viewModel.setEvent("On Resume was fired on "+time+"\n")
        viewModel.setEvent("******************"+"\n")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.i(LOG_TAG,"on_Pause")
        getTime()
        viewModel.setEvent("On Pause was fired on "+time+"\n")
        viewModel.setEvent("*******************"+"\n")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.i(LOG_TAG,"on_Create")
        getTime()
        viewModel.setEvent("On Create was fired on "+time+"\n")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.i(LOG_TAG,"on_Start")
        getTime()
        viewModel.setEvent("On Start was fired on "+time+"\n")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.i(LOG_TAG,"on_Stop")
        getTime()
        viewModel.setEvent("On Stop was fired on "+time+"\n")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.i(LOG_TAG,"on_Destroy")
        getTime()
        viewModel.setEvent("On Destroy was fired on "+time+"\n")
        viewModel.setEvent("****************"+"\n")
    }
}