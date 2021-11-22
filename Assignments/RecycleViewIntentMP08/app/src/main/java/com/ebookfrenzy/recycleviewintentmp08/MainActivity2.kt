package com.ebookfrenzy.recycleviewintentmp08

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.ebookfrenzy.recycleviewintentmp08.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding

    var theData = Data.instanceOfData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


        val extras = intent.extras?:return

        val theTitle2 = extras.getInt("title")
        val theDetails2 = extras.getInt("details")
        val theImage2 = extras.getInt("image")

        binding.argText.text = theData.dataTitles[theTitle2]
        binding.argImg.setImageResource(theData.dataImages[theImage2])
        binding.argDetail.text = theData.dataDetails[theDetails2]

    }


}