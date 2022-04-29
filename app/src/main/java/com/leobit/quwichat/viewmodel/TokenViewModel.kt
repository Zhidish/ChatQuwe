package com.leobit.quwichat.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.leobit.quwichat.network.LoginResponse
import com.leobit.quwichat.network.CallsToApi
import com.leobit.quwichat.other.Const
import java.lang.Exception
import kotlin.jvm.Throws

class TokenViewModel : ViewModel() {


    open var _properties_token = MutableLiveData<String>()

    open val properties_token: LiveData<String> = _properties_token


    suspend fun getToken(email: String, password: String): String {

            var response = CallsToApi.chatService.loginUser(email, password)
            return response.token


    }

    suspend fun signUp(name: String, email: String, password: String): String {

            var response = CallsToApi.chatService.signUp(name, email, password)
            return response.token


    }


}