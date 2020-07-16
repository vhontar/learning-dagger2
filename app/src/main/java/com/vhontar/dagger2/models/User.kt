package com.vhontar.dagger2.models

import com.google.gson.annotations.SerializedName

/**
 * Created by Vladyslav Hontar (vhontar) on 16.07.20.
 */
data class User(
    @SerializedName("id") val id: Int = 0,
    @SerializedName("username") val username: String = "",
    @SerializedName("email") val email: String = "",
    @SerializedName("website") val website: String = ""
)