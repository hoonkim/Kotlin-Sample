package com.example.testapplication.ui.main

import androidx.lifecycle.ViewModel
import com.example.testapplication.di.ViewModelKey
import com.example.testapplication.ui.destination.DestFragment
import com.example.testapplication.ui.destination.DestViewModel
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

}