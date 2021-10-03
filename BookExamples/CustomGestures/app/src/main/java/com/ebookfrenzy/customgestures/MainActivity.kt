package com.ebookfrenzy.customgestures

import android.gesture.Gesture
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.customgestures.databinding.ActivityMainBinding
import android.gesture.GestureLibraries
import android.gesture.GestureLibrary
import android.gesture.GestureOverlayView
import android.gesture.GestureOverlayView.OnGesturePerformedListener
import android.widget.Toast

class MainActivity : AppCompatActivity(), OnGesturePerformedListener {

    private lateinit var binding: ActivityMainBinding
    var gLibrary: GestureLibrary? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gestureSetup()

    }

    private fun gestureSetup() {
        gLibrary = GestureLibraries.fromRawResource(this, R.raw.gesture)

        if (gLibrary?.load() == false) {
            finish()
        }

        binding.gOverlay.addOnGesturePerformedListener(this)

    }

    override fun onGesturePerformed(overlay: GestureOverlayView, gesture: Gesture) {

        val prediction = gLibrary?.recognize(gesture)

        prediction?.let {
            if (it.size > 0 && it[0].score > 1.0) {
                val action = it[0].name
                Toast.makeText(this, action, Toast.LENGTH_SHORT).show()
            }
        }

    }
}