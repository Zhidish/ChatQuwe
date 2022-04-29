package com.leobit.quwichat.network


import com.squareup.moshi.Json

data class UserSettings(
    @Json(name = "cache_updated")
    val cacheUpdated: Boolean,
    @Json(name = "client_settings")
    val clientSettings: ClientSettings?,
    @Json(name = "dta_mute_until")
    val dtaMuteUntil: Any?,
    @Json(name = "is_mute_chats")
    val isMuteChats: Boolean,
    @Json(name = "lang")
    val lang: String?,
    @Json(name = "mute_until_period")
    val muteUntilPeriod: Int
)