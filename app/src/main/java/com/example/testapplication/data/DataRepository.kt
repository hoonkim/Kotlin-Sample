package com.example.testapplication.data

import androidx.lifecycle.LiveData
import com.example.testapplication.data.entity.Data
import com.example.testapplication.data.local.DataDao
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataRepository @Inject constructor(private val dataDao: DataDao) {
    fun getDatas() : LiveData<List<Data>> {
        return dataDao.getDatas()
    }

    fun insertData(number:Int, text:String): Completable {
        return Completable.fromAction{ dataDao.insertData(Data(number, text)) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}