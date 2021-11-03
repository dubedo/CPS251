package com.ebookfrenzy.lifecycledemomp05.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.MutableLiveData


class MainViewModel : ViewModel() {

    companion object {

        private var theMessage = ""
        private var message: MutableLiveData<String> = MutableLiveData()

        fun addMessage(newMessage: String) {
            theMessage = theMessage + newMessage
            message.setValue(theMessage)
        }

    }

    fun getMessage(): MutableLiveData<String> {
        return message
    }


}