package com.ebookfrenzy.lifecycledemomp05

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

import com.ebookfrenzy.lifecycledemomp05.ui.main.MainFragment


class DemoObserver : LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResume(): String {
        return "Resumed"
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPause(): String {
        return "Paused"
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreate(): String {
        return "Created"
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStart(): String {
        return "Started"
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStop(): String {
        return "Stopped"
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy(): String {
        return "Destroyed"
    }


}