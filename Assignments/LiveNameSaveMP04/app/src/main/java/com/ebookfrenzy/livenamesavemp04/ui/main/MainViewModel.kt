package com.ebookfrenzy.livenamesavemp04.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    var nameText: MutableLiveData<String> = MutableLiveData()
    var savedName: MutableLiveData<String> = MutableLiveData()

    fun storeName() {


        if(!nameText.value.isNullOrBlank()) {
            savedName.value = nameText.value + "\n" + savedName.value
        } else {
            savedName.value = "No Name Added"
        }




    }




}