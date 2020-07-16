package com.vhontar.dagger2.network.auth

import com.vhontar.dagger2.models.User
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Created by Vladyslav Hontar (vhontar) on 16.07.20.
 */

interface AuthApi {
    @GET("/users/{id}")
    fun getUser(@Path("id") id: Int): Flowable<User>
}