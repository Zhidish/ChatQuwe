package com.leobit.quwichat.network

import retrofit2.Response
import com.leobit.quwichat.other.Const.BASE_URL
import com.squareup.moshi.Moshi
import retrofit2.converter.moshi.MoshiConverterFactory
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.http.*

interface Quwi {
    @FormUrlEncoded
    @POST("auth/login")
    suspend fun loginUser(
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse

    @FormUrlEncoded
    @POST("auth/signup")
    suspend fun signUp(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): LoginResponse

    @GET("auth/init?")
    suspend fun loginByToken(@Query("TOKEN") token: String): AppInit

    @Headers("Content-Type: application/json;charset=UTF-8")
    @GET("chat-channels")
    suspend fun getChannels(@Header("Authorization") auth: String): Channels

}

private val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()


private val retrofitService = Retrofit
    .Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()


object CallsToApi {

    val chatService: Quwi by lazy { retrofitService.create(Quwi::class.java) }


}