package com.leobit.quwichat.network


import com.squareup.moshi.Json

data class AuthItems(
    @Json(name = "can_edit_time")
    val canEditTime: Boolean,
    @Json(name = "chat")
    val chat: Boolean,
    @Json(name = "coder")
    val coder: Boolean,
    @Json(name = "disc_space")
    val discSpace: Boolean,
    @Json(name = "instant_screen")
    val instantScreen: Boolean,
    @Json(name = "member_area")
    val memberArea: Boolean,
    @Json(name = "owner")
    val owner: Boolean,
    @Json(name = "screens_month")
    val screensMonth: Boolean,
    @Json(name = "timelapse_video")
    val timelapseVideo: Boolean,
    @Json(name = "tracked_timer_month")
    val trackedTimerMonth: Boolean,
    @Json(name = "trial")
    val trial: Boolean
)