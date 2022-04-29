package com.leobit.quwichat.network


import com.squareup.moshi.Json

data class UserX(
    @Json(name = "avatar_url")
    val avatarUrl: String?,
    @Json(name = "name")
    val name: String
)