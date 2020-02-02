package com.example.testapplication

import android.app.Application
import com.example.testapplication.data.local.LocalDataModule
import com.example.testapplication.ui.UIModule
import com.example.testapplication.ui.main.MainModule

import javax.inject.Singleton

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Singleton
@Component(modules = [AndroidInjectionModule::class, LocalDataModule::class, UIModule::class])
interface AppComponent : AndroidInjector<TestApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
