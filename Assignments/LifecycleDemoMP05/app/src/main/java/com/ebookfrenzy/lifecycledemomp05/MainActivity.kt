package com.ebookfrenzy.lifecycledemomp05

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ebookfrenzy.lifecycledemomp05.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()
        }
    }
}