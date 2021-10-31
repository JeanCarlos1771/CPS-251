package com.example.life_cycle_awareness

import android.util.Log
import androidx.lifecycle.OnLifecycleEvent
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import com.example.life_cycle_awareness.ui.main.MainFragment
import java.text.SimpleDateFormat
import java.util.*


class Demo_Observer(private val context: MainFragment, private val lifecycle: Lifecycle) : LifecycleObserver{

    private val LOG_TAG = "Demo_Observer"

    var cycleStatus = ""
    var time = ""

    private fun getTime() {
        val sdf = SimpleDateFormat("hh:mm:ss.SSSS")
        val currentDate = sdf.format(Date())

        time = currentDate.toString()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        getTime()
        Log.i(LOG_TAG,"on_Resume ")
        cycleStatus = "OnResume was fired on " + time

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        getTime()
        Log.i(LOG_TAG,"on_Pause")
        cycleStatus = "OnPause was fired on " + time
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        getTime()
        Log.i(LOG_TAG,"on_Create")
        cycleStatus = "OnCreate was fired on " + time
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        getTime()
        Log.i(LOG_TAG,"on_Start")
        cycleStatus = "OnStart was fired on " + time
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        getTime()
        Log.i(LOG_TAG,"on_Stop")
        cycleStatus = "OnStop was fired on " + time
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        getTime()
        Log.i(LOG_TAG,"on_Destroy")
        cycleStatus = "OnDestroy was fired on " + time
    }
}