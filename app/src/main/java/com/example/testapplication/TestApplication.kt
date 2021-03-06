package com.example.testapplication

import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class TestApplication : DaggerApplication() {
    override fun onCreate() {
        super.onCreate()
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().application(this).build()
    }
}
