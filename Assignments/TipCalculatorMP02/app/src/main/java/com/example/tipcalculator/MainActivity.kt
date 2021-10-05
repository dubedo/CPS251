package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tipcalculator.databinding.ActivityMainBinding
import android.view.View
import android.view.animation.AccelerateInterpolator

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.theButton.setOnClickListener {

            if (binding.billAmount.text.toString() == "") {
                binding.calculatedTips.text = "You Must Enter A Bill Amount"
            } else {

                var validBill = Integer.parseInt(binding.billAmount.text.toString())

                binding.calculatedTips.text =
                    "10% = " + String.format("%.2f", validBill * 1.10) + "\n" +
                            "15% = " + String.format("%.2f", validBill * 1.15) + "\n" +
                            "20% = " + String.format("%.2f", validBill * 1.20) + "\n"


            }


        }


    }
}