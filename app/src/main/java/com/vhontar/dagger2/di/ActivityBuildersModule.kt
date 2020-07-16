package com.vhontar.dagger2.di

import com.vhontar.dagger2.di.auth.AuthModule
import com.vhontar.dagger2.di.auth.AuthViewModelModule
import com.vhontar.dagger2.ui.auth.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Vladyslav Hontar (vhontar) on 13.07.20.
 */

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector(
        modules = [
            AuthViewModelModule::class,
            AuthModule::class
        ]
    )
    abstract fun contributeAuthActivity(): AuthActivity
}