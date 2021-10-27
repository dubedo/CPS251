package com.ebookfrenzy.lifecycledemo

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LifecycleRegistry

class DemoOwner:LifecycleOwner {

    private val lifecycleRegistry:LifecycleRegistry

    init {
        lifecycleRegistry = LifecycleRegistry(this)
        getLifecycle().addObserver(DemoObserver())
    }

    override fun getLifecycle():Lifecycle {
        return lifecycleRegistry
    }

    fun startOwner() {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START)
    }

    fun stopOwner() {
        lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP)
    }


}