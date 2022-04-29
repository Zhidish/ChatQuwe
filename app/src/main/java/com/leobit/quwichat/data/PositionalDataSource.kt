package com.leobit.quwichat.data

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.leobit.quwichat.network.CallsToApi
import com.leobit.quwichat.network.Channel
import com.leobit.quwichat.network.Channels
import com.leobit.quwichat.other.Const
import retrofit2.HttpException
import java.io.IOException
import com.leobit.quwichat.viewmodel.TokenViewModel

class PositionalChaTDataSource : PagingSource<Int, Channel>() {
    override fun getRefreshKey(state: PagingState<Int, Channel>): Int? {
        return state.anchorPosition.let {
            if (it != null) {
                state.closestPageToPosition(it)?.prevKey?.plus(1)
                    ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
                    ?: state.closestPageToPosition(it)?.prevKey
            } else 1
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Channel> {

        return try {
            val pageNumber = params.key ?: 0
            val chan: Channels? = Const.token?.let { CallsToApi.chatService.getChannels("Bearer ${it}") }
            if (chan != null) {
                val prevPage = if (pageNumber > 0) pageNumber - 1 else null
                val nextPage = if (pageNumber <= chan.channels.size) pageNumber + 1 else null

                LoadResult.Page(
                    data = chan.channels,
                    prevKey = prevPage,
                    nextKey = nextPage
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey =null,
                    nextKey = null)
            }

        } catch (e: IOException) {
            Log.e("IOException", "IOException")
            LoadResult.Error(e)
        } catch (e: HttpException) {
            Log.e("HttpException", "HttpException")
            LoadResult.Error(e)
        } catch (e: Exception) {
            Log.e("Exception", e.localizedMessage)
            LoadResult.Error(e)

        }

    }


}

