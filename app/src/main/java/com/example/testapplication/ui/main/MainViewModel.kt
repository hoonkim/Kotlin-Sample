package com.example.testapplication.ui.main

import android.app.Application
import android.content.Context
import androidx.databinding.ObservableInt
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val number: ObservableInt = ObservableInt(0)

    fun increase() {
        number.set(number.get() + 1)
    }
}
