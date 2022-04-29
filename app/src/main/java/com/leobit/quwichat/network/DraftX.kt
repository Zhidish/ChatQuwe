package com.leobit.quwichat.network


import com.squareup.moshi.Json

data class DraftX(
    @Json(name = "id_reply")
    val idReply: Any?,
    @Json(name = "text")
    val text: Any?
)