package com.vhontar.dagger2.di.auth

import androidx.lifecycle.ViewModel
import com.vhontar.dagger2.di.ViewModelKey
import com.vhontar.dagger2.ui.auth.AuthViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Vladyslav Hontar (vhontar) on 14.07.20.
 */

@Module
abstract class AuthViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(AuthViewModel::class)
    abstract fun bindAuthViewModel(viewModel: AuthViewModel): ViewModel

}