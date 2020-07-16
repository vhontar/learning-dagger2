package com.vhontar.dagger2.di

import androidx.lifecycle.ViewModelProvider
import com.vhontar.dagger2.viewmodels.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

/**
 * Created by Vladyslav Hontar (vhontar) on 14.07.20.
 */

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelProviderFactory: ViewModelProviderFactory): ViewModelProvider.Factory
}