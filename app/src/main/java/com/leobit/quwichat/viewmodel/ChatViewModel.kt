package com.leobit.quwichat.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.leobit.quwichat.data.PositionalChaTDataSource
import com.leobit.quwichat.network.Channel

class ChatViewModel  : ViewModel() {


    open val _properties = MutableLiveData<List<Channel>>()

    open val properties: LiveData<List<Channel>> = _properties

    val flow = Pager(
        PagingConfig(pageSize=1)
    ) {
       PositionalChaTDataSource()
    }.flow
        .cachedIn(viewModelScope)



}