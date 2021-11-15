package com.ebookfrenzy.recycler_cardviewmp07

class Data {

    companion object {

        private val dataTitles = arrayOf(
            "Chapter One", "Chapter Two", "Chapter Three", "Chapter Four", "Chapter Five", "Chapter Six",
            "Chapter Seven", "Chapter Eight"
        )

        private val dataDetails = arrayOf(
            "Item one details", "Item two details", "Item three details", "Item four details",
            "Item five details", "Item six details", "Item seven details", "Item eight details"
        )

        private val dataImages = intArrayOf(
            R.drawable.android_image_1, R.drawable.android_image_2, R.drawable.android_image_3,
            R.drawable.android_image_4, R.drawable.android_image_5, R.drawable.android_image_6, R.drawable.android_image_7,
            R.drawable.android_image_8
        )

        var vm = MainViewModel

        fun populateArrays() {
            for (i in 0..7) {
                vm.setValue(dataTitles.random(), dataDetails.random(), dataImages.random())
            }
        }


    }


}