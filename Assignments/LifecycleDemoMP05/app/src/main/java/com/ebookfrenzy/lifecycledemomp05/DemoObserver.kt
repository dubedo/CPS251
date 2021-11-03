package com.ebookfrenzy.lifecycledemomp05

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

import com.ebookfrenzy.lifecycledemomp05.ui.main.MainViewModel
import java.time.LocalTime

class DemoObserver : LifecycleObserver {

    private var instanceOfMVM = MainViewModel

    private fun getDateTime(): String {
        return LocalTime.now().toString()
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume() {
        instanceOfMVM.addMessage("onResume Fired: " + getDateTime() + " \n")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause() {
        instanceOfMVM.addMessage("onPause Fired: " + getDateTime() + " \n")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate() {
        instanceOfMVM.addMessage("onCreate Fired: " + getDateTime() + " \n")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart() {
        instanceOfMVM.addMessage("onStart Fired: " + getDateTime() + " \n")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop() {
        instanceOfMVM.addMessage("onStop Fired: " + getDateTime() + " \n")
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        instanceOfMVM.addMessage("onDestroy Fired: " + getDateTime() + " \n")
    }


}