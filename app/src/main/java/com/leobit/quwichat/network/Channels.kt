package com.leobit.quwichat.network


import com.squareup.moshi.Json

data class Channels(
    @Json(name = "channels")
    val channels: List<Channel>
)