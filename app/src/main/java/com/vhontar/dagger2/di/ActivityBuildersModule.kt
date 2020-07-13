package com.vhontar.dagger2.di

import com.vhontar.dagger2.AuthActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by Vladyslav Hontar (vhontar) on 13.07.20.
 */

@Module
abstract class ActivityBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeAuthActivity(): AuthActivity
}