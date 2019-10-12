package com.example.testapplication.ui.main

import androidx.appcompat.app.AppCompatActivity

import android.content.res.Configuration
import android.os.Bundle

import com.example.testapplication.R
import com.example.testapplication.ui.main.MainFragment

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
