package com.leobit.quwichat.network


import com.squareup.moshi.Json

data class LoginResponse(
    @Json(name = "already_join_project")
    val alreadyJoinProject: Any?,
    @Json(name = "app_init")
    val appInit: AppInit,
    @Json(name = "token")
    val token: String
)