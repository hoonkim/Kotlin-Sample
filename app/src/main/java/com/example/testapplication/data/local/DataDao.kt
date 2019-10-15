package com.example.testapplication.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.testapplication.data.entity.Data

@Dao
abstract class DataDao() {
    @Query("SELECT * FROM Data")
    abstract fun getDatas(): LiveData<List<Data>>

    @Insert
    abstract suspend fun insertData(data: Data)
}

