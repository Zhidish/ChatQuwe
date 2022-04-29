package com.leobit.quwichat.network


import com.squareup.moshi.Json

data class Company(
    @Json(name = "dta_create")
    val dtaCreate: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "id_user")
    val idUser: Int,
    @Json(name = "is_my")
    val isMy: Boolean,
    @Json(name = "is_plan_almost_used")
    val isPlanAlmostUsed: Boolean,
    @Json(name = "logo_url")
    val logoUrl: String?,
    @Json(name = "max_file_count")
    val maxFileCount: Int,
    @Json(name = "max_file_size")
    val maxFileSize: Int,
    @Json(name = "name")
    val name: String?,
    @Json(name = "owner_fullname")
    val ownerFullname: String?,
    @Json(name = "screens_interval")
    val screensInterval: Int,
    @Json(name = "screens_quality")
    val screensQuality: Int,
    @Json(name = "timezone")
    val timezone: String?,
    @Json(name = "timezone_offset")
    val timezoneOffset: Int,
    @Json(name = "uid")
    val uid: String?,
    @Json(name = "updated")
    val updated: Int
)