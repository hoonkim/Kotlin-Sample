package com.example.testapplication.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.testapplication.data.DataRepository
import com.example.testapplication.data.entity.Data
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainViewModel @Inject constructor(application: Application,
                                        val dataRepository: DataRepository) :AndroidViewModel(application) {
    val number: MutableLiveData<Int> = MutableLiveData()
    val text: MutableLiveData<String> = MutableLiveData()

    val dataList: LiveData<List<Data>>

    val compositeDisposable:CompositeDisposable = CompositeDisposable()

    init {
        number.value = 0
        text.value = ""

        dataList = dataRepository.getDatas()
    }

    fun increase() {
        number.postValue(number.value as Int + 1)
    }

    fun saveData() {
        dataRepository.insertData(number.value as Int, text.value as String)
                .subscribe{Log.d("Hoon", "Save Complete")}
                .let(compositeDisposable::add)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}
