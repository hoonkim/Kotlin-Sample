package com.example.testapplication.data.repository

import com.example.testapplication.data.local.LocalDataModule
import dagger.Module

@Module(includes = [LocalDataModule::class])
interface DataModule