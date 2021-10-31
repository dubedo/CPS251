package com.ebookfrenzy.lifecycledemomp05.ui.main

import androidx.lifecycle.ViewModel
import com.ebookfrenzy.lifecycledemomp05.DemoObserver

import com.ebookfrenzy.lifecycledemomp05.ui.main.MainFragment


class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    var messageText: String = ""
    val observer = DemoObserver()

    fun settingTextStart() {

    }

    fun setTextCreate() {
        messageText = observer.onCreate()
    }

    fun setTextDestroy() {
        messageText = observer.onDestroy()
    }

    fun setTextPaused() {
        messageText = observer.onPause()
    }

    fun setTextResumed() {
        messageText = observer.onResume()
    }

    fun setTextStart() {
        messageText = observer.onStart()
    }

    fun setTextStop() {
        messageText = observer.onStop()
    }


}