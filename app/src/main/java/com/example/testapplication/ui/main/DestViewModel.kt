package com.example.testapplication.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class DestViewModel @Inject constructor(application: Application) : AndroidViewModel(application)  {
    val number:MutableLiveData<Int> = MutableLiveData()

    init {
        number.value = 1
    }
}
