package com.ebookfrenzy.recycler_cardviewmp07

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    companion object {

        private var theTitles: ArrayList<String> = arrayListOf()
        private var theDetails: ArrayList<String> = arrayListOf()
        private var theImages: ArrayList<Int> = arrayListOf()

        fun setValue(title: String, detail: String, image: Int) {
            theTitles.add(title)
            theDetails.add(detail)
            theImages.add(image)
        }

        fun getTitles(): ArrayList<String> {
            return theTitles
        }

        fun getDetails(): ArrayList<String> {
            return theDetails
        }

        fun getImages(): ArrayList<Int> {
            return theImages
        }


    }

}