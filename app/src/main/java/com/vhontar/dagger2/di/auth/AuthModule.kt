package com.vhontar.dagger2.di.auth

import com.vhontar.dagger2.network.auth.AuthApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit

/**
 * Created by Vladyslav Hontar (vhontar) on 16.07.20.
 */

@Module
class AuthModule {
    @Provides
    fun provideAuthApi(retrofit: Retrofit): AuthApi {
        return retrofit.create(AuthApi::class.java)
    }
}