package com.leobit.quwichat.network


import com.squareup.moshi.Json

data class Channel(
    @Json(name = "custom_info")
    val customInfo: Any?,
    @Json(name = "draft")
    val draft: DraftX?,
    @Json(name = "dta_change_msg")
    val dtaChangeMsg: String?,
    @Json(name = "dta_create")
    val dtaCreate: String?,
    @Json(name = "dta_last_read")
    val dtaLastRead: String,
    @Json(name = "dta_pin")
    val dtaPin: Any?,
    @Json(name = "id")
    val id: Int,
    @Json(name = "id_partner")
    val idPartner: Int?,
    @Json(name = "id_project")
    val idProject: Any?,
    @Json(name = "id_users")
    val idUsers: List<Int>,
    @Json(name = "is_hide_in_chats_list")
    val isHideInChatsList: Boolean,
    @Json(name = "is_mute")
    val isMute: Boolean,
    @Json(name = "is_starred")
    val isStarred: Boolean,
    @Json(name = "is_unread_manual")
    val isUnreadManual: Boolean,
    @Json(name = "message_last")
    val messageLast: MessageLast?,
    @Json(name = "mute_until_period")
    val muteUntilPeriod: Int?,
    @Json(name = "pin_to_top")
    val pinToTop: Boolean?,
    @Json(name = "type")
    val type: String?
)