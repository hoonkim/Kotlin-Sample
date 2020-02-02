package com.example.testapplication.ui.destination

import androidx.lifecycle.ViewModel
import com.example.testapplication.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
interface DestModule {

    @ContributesAndroidInjector
    fun contributeDestFragment(): DestFragment

    @Binds
    @IntoMap
    @ViewModelKey(DestViewModel::class)
    fun provideDestViewModel(viewModel: DestViewModel): ViewModel
}