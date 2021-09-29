package com.ebookfrenzy.motionevent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ebookfrenzy.motionevent.databinding.ActivityMainBinding
import android.view.MotionEvent
import androidx.constraintlayout.widget.ConstraintSet

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.activityMain.setOnTouchListener { _, m: MotionEvent ->
            handleTouch(m)
            true
        }

    }

    private fun handleTouch(m: MotionEvent) {
        val pointerCount = m.pointerCount

        for (i in 0 until pointerCount) {
            val x = m.getX(i)
            val y = m.getY(i)
            val id = m.getPointerId(i)
            val action = m.actionMasked
            val actionIndex = m.actionIndex
            var actionString: String

            when (action) {
                MotionEvent.ACTION_DOWN -> actionString = "Down"
                MotionEvent.ACTION_UP -> actionString = "Up"
                MotionEvent.ACTION_POINTER_DOWN -> actionString = "Pointer Down"
                MotionEvent.ACTION_POINTER_UP -> actionString = "Pointer Up"
                MotionEvent.ACTION_MOVE -> actionString = "Move"

                else -> actionString = ""
            }

            val touchStatus = "Action: $actionString Index: $actionIndex ID: $id X: $x Y: $y"

            if (id == 0) {
                binding.textView1.text = touchStatus
            } else {
                binding.textView2.text = touchStatus
            }
        }
    }
}