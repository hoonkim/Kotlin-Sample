package com.example.testapplication.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.testapplication.data.entity.Data

@Database(entities = arrayOf(Data::class), version = 1, exportSchema = false)
abstract class TestDatabase : RoomDatabase() {
    abstract fun dataDao(): DataDao
}