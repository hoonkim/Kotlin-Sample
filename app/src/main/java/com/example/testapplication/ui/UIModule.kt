package com.example.testapplication.ui

import com.example.testapplication.ui.destination.DestModule
import com.example.testapplication.ui.main.MainModule
import dagger.Module

@Module(includes = [DestModule::class, MainModule::class])
interface UIModule