package com.leobit.quwichat.network


import com.squareup.moshi.Json

data class ClientSettings(
    @Json(name = "bell_autoopen")
    val bellAutoopen: Boolean,
    @Json(name = "cache_updated")
    val cacheUpdated: Boolean,
    @Json(name = "chat_active")
    val chatActive: Boolean,
    @Json(name = "comment_video_autoplay")
    val commentVideoAutoplay: Boolean,
    @Json(name = "hash")
    val hash: String,
    @Json(name = "redirect_to_ticket")
    val redirectToTicket: Boolean,
    @Json(name = "tutorial_step")
    val tutorialStep: Any?
)