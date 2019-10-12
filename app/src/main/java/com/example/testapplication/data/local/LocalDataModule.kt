package com.example.testapplication.data.local

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Provides
    fun provideDataDao(database: TestDatabase):DataDao {
        return database.dataDao()
    }

    @Provides
    @Singleton
    fun provideDataBase(application: Application):TestDatabase {
        return Room.databaseBuilder(application,TestDatabase::class.java, "test.db").build()
    }
}