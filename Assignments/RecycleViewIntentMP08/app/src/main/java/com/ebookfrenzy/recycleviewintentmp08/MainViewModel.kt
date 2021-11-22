package com.ebookfrenzy.recycleviewintentmp08

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    companion object {
        fun instanceOfMVM() = MainViewModel()

        var detailValues: ArrayList<ArrayList<Int>> = arrayListOf()
    }

    fun populateArrays() {
        for (i in 0..7) {
            detailValues.add(arrayListOf((0..7).random(), (0..7).random(), (0..7).random()))
        }
    }


}

