package com.vhontar.dagger2.di

import android.app.Application
import com.vhontar.dagger2.BaseApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * Created by Vladyslav Hontar (vhontar) on 13.07.20.
 */

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        ActivityBuildersModule::class,
        AppModule::class,
        ViewModelFactoryModule::class
    ]
)
interface AppComponent: AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {
        // must to do always
        fun build(): AppComponent

        @BindsInstance
        fun application(application: Application): Builder
    }
}