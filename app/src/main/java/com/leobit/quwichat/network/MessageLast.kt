package com.leobit.quwichat.network


import com.squareup.moshi.Json

data class MessageLast(
    @Json(name = "dta_create")
    val dtaCreate: String?,
    @Json(name = "file")
    val `file`: Any?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "id_channel")
    val idChannel: Int?,
    @Json(name = "id_user")
    val idUser: Int?,
    @Json(name = "is_edited")
    val isEdited: Boolean?,
    @Json(name = "is_read")
    val isRead: Int?,
    @Json(name = "is_starred")
    val isStarred: Boolean?,
    @Json(name = "reply_on")
    val replyOn: Any?,
    @Json(name = "snippet")
    val snippet: String?,
    @Json(name = "text")
    val text: String?,
    @Json(name = "user")
    val user: UserX?
)