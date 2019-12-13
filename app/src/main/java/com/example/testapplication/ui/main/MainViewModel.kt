package com.example.testapplication.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.testapplication.data.DataRepository
import com.example.testapplication.data.entity.Data
import io.reactivex.disposables.CompositeDisposable
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel @Inject constructor(application: Application,
                                        val dataRepository: DataRepository) : AndroidViewModel(application) {
    val number: MutableLiveData<Int> = MutableLiveData()
    val text: MutableLiveData<String> = MutableLiveData()

    val dataList: LiveData<List<Data>>

    init {
        number.value = 0
        text.value = ""

        dataList = dataRepository.getDatas()
    }

    fun increase() {
        number.postValue(number.value as Int + 1)
        Log.d("Hoon", "Number : " + number.value)
    }

    fun saveData() = viewModelScope.launch {
        dataRepository.insertData(number.value as Int, text.value as String)
        Log.d("Hoon", "Save Complete")
    }
}
