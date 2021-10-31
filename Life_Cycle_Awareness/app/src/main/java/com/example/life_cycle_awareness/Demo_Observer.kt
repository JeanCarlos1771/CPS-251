package com.example.life_cycle_awareness

import android.util.Log
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LifecycleOwner
import java.text.SimpleDateFormat
import java.util.*


class Demo_Observer: LifecycleObserver{

    private val LOG_TAG = "Demo_Observer"

    var cycleStatus = arrayListOf<String>()
    var time = ""

    private fun getTime() {
        val sdf = SimpleDateFormat("hh:mm:ss.SSSS")
        val currentDate = sdf.format(Date())

        time = currentDate.toString()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        Log.i(LOG_TAG,"on_Resume ")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        Log.i(LOG_TAG,"on_Pause")
    }
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        Log.i(LOG_TAG,"on_Create")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        Log.i(LOG_TAG,"on_Start")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        Log.i(LOG_TAG,"on_Stop")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        Log.i(LOG_TAG,"on_Destroy")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    fun onAny(owner: LifecycleOwner,event: Lifecycle.Event){
        getTime()
        var eventName = event.name
        cycleStatus.add(eventName + " was fired on "+time)
    }
}