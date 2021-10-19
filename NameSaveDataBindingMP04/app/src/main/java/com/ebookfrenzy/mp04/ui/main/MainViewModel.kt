package com.ebookfrenzy.mp04.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    // private var storedNames:String = ""

    var storedNames:MutableLiveData<String> = MutableLiveData()

    fun setNamesList() {
        storedNames.let {
            if(!it.value.equals("")) {
                storedNames.value = it.value?.toString() + "\n" + storedNames
            } else {
                storedNames.value = "No Name Entered"
            }


        }
    }


}