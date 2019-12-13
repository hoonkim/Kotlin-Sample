package com.example.testapplication.ui.main

import androidx.lifecycle.ViewModel
import com.example.testapplication.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
interface MainModule {
    @ContributesAndroidInjector
    fun contributeMainFragment(): MainFragment

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun provideMainViewModel(viewModel: MainViewModel): ViewModel

    @ContributesAndroidInjector
    fun contributeDestFragment(): DestFragment

    @Binds
    @IntoMap
    @ViewModelKey(DestViewModel::class)
    fun provideDestViewModel(viewModel: DestViewModel): ViewModel
}