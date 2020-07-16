package com.vhontar.dagger2.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.LiveDataReactiveStreams
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import com.vhontar.dagger2.models.User
import com.vhontar.dagger2.network.auth.AuthApi
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by Vladyslav Hontar (vhontar) on 14.07.20.
 */
class AuthViewModel @Inject constructor(private val authApi: AuthApi) : ViewModel() {

    private val authUser: MediatorLiveData<AuthResource<User?>> = MediatorLiveData()

    fun observeUser(): LiveData<AuthResource<User?>> {
        return authUser
    }

    fun authWithId(userId: Int) {
        authUser.value = AuthResource.loading(null)

        val source: LiveData<AuthResource<User?>> = LiveDataReactiveStreams.fromPublisher(
            authApi.getUser(userId)
                .onErrorReturn {
                    User(-1)
                }
                .map {
                    return@map if (it.id == -1) {
                        AuthResource.error<User>("Could not authenticate", null)
                    } else {
                        AuthResource.authenticated(it)
                    }
                }
                .subscribeOn(Schedulers.io())
        )

        authUser.addSource(source) {
            authUser.value = it
            authUser.removeSource(source)
        }
    }
}