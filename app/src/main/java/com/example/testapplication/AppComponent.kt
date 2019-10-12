package com.example.testapplication

import android.app.Application

import javax.inject.Singleton

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

@Singleton
@Component(modules = [AndroidInjectionModule::class])
interface AppComponent : AndroidInjector<TestApplication> {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}
