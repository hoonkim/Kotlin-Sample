package com.example.testapplication.ui.destination

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class DestViewModel @Inject constructor(application: Application) : AndroidViewModel(application)  {
    val message:MutableLiveData<String> = MutableLiveData()
}
