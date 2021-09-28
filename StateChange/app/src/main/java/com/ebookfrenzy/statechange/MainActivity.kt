package com.ebookfrenzy.statechange

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import com.ebookfrenzy.statechange.databinding.ActivityMainBinding
import android.util.Log

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val TAG = "StateChange"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Log.i(TAG, "OnCreate")

    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        Log.i(TAG, "onRestoreInstanceState")
    }

    override fun onStart() {
        super.onStart()

        Log.i(TAG, "onStart")
    }

    override fun onRestart() {
        super.onRestart()

        Log.i(TAG, "onRestart")
    }

    override fun onResume() {
        super.onResume()

        Log.i(TAG, "onResume")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        Log.i(TAG, "onSaveInstanceState")
    }

    override fun onPause() {
        super.onPause()

        Log.i(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i(TAG, "onDestroy")
    }
}