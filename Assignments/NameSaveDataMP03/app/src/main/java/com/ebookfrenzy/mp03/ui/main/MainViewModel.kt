package com.ebookfrenzy.mp03.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    private var storedNames:String = ""

    fun setNameList(value:String) {
        storedNames = value + "\n" + storedNames;
    }

    fun getNameList():String {
        return storedNames;
    }



}