package com.leobit.quwichat.network


import com.squareup.moshi.Json

data class UserSettingsGlobal(
    @Json(name = "client_settings")
    val clientSettings: Any?,
    @Json(name = "is_chat_email_notification")
    val isChatEmailNotification: Boolean
)