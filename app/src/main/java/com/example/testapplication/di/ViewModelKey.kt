package com.example.testapplication.di

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy

import androidx.lifecycle.ViewModel
import dagger.MapKey
import kotlin.reflect.KClass

@Retention(RetentionPolicy.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)
