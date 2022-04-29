package com.leobit.quwichat.network


import com.squareup.moshi.Json

data class AppInit(
    @Json(name = "auth_items")
    val authItems: AuthItems?,
    @Json(name = "chats_count_unread")
    val chatsCountUnread: Int,
    @Json(name = "companies")
    val companies: List<Company?>,
    @Json(name = "hidden_projects")
    val hiddenProjects: List<Any>,
    @Json(name = "user")
    val user: User?,
    @Json(name = "user_settings")
    val userSettings: UserSettings?,
    @Json(name = "user_settings_global")
    val userSettingsGlobal: UserSettingsGlobal?
)