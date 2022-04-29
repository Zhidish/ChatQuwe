package com.leobit.quwichat.network


import com.squareup.moshi.Json

data class User(
    @Json(name = "avatar_url")
    val avatarUrl: String?,
    @Json(name = "dta_activity")
    val dtaActivity: String,
    @Json(name = "dta_create")
    val dtaCreate: String?,
    @Json(name = "dta_timer_activity")
    val dtaTimerActivity: String?,
    @Json(name = "due_penalties")
    val duePenalties: Int,
    @Json(name = "email")
    val email: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "id_company")
    val idCompany: Int,
    @Json(name = "is_active")
    val isActive: Boolean,
    @Json(name = "is_chat_email_notification")
    val isChatEmailNotification: Boolean,
    @Json(name = "is_online")
    val isOnline: Int,
    @Json(name = "is_shared_from_me")
    val isSharedFromMe: Boolean,
    @Json(name = "is_telegram_connected")
    val isTelegramConnected: Boolean,
    @Json(name = "is_timer_online")
    val isTimerOnline: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "nick")
    val nick: String,
    @Json(name = "projects")
    val projects: List<Any?>,
    @Json(name = "role")
    val role: String,
    @Json(name = "telegram_connect_url")
    val telegramConnectUrl: String,
    @Json(name = "timer_last")
    val timerLast: Any?,
    @Json(name = "timezone_offset")
    val timezoneOffset: Int
)