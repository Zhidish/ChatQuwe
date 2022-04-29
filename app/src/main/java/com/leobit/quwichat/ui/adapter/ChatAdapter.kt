package com.leobit.quwichat.ui.adapter

import android.annotation.SuppressLint
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.leobit.quwichat.R
import com.leobit.quwichat.databinding.ChatItemBinding
import com.leobit.quwichat.network.Channel


val channel_comporator = object :
    DiffUtil.ItemCallback<Channel>() {

    override fun areItemsTheSame(oldItem: Channel, newItem: Channel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Channel, newItem: Channel): Boolean {
        return oldItem.id == newItem.id
    }
}


class ChatAdapter() :
    PagingDataAdapter<Channel, ChatAdapter.ChatViewHolder>(
        channel_comporator
    ) {

    class ChatViewHolder(
        var binding: ChatItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(chanell: Channel) {

            binding.lastMessageText.text = chanell.messageLast?.text ?: ""
            binding.chatName.text = chanell.messageLast?.user?.name ?: ""
            binding.time.text = chanell.messageLast?.dtaCreate ?: ""
            if (chanell.messageLast?.isRead!! > 0) {
                binding.checkedImg.visibility = View.VISIBLE
            }

            //using Coil for obtaining image and putting placeholder and error vector asset
            binding.avatar.let {
                val imgUrl =
                    chanell.messageLast?.user?.avatarUrl?.toUri()?.buildUpon()?.scheme("https")
                        ?.build()
                if (imgUrl != null) {
                    it.load(imgUrl) {
                        placeholder(R.drawable.loading_animation)
                        error(R.drawable.ic_broken_image)
                    }
                } else {
                    it.setImageResource(R.drawable.ic_broken_image)

                }


            }
            binding.executePendingBindings()
        }
    }


    override fun onBindViewHolder(
        holder: ChatViewHolder,
        @SuppressLint("RecyclerView") position: Int
    ) {

        val chanell = getItem(position)
        if (chanell != null) {
            holder.bind(chanell)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        return ChatViewHolder(ChatItemBinding.inflate(LayoutInflater.from(parent.context)))
    }
}




