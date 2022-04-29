package com.leobit.quwichat.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.paging.PagingData
import androidx.paging.PagingDataAdapter
import com.leobit.quwichat.databinding.CharacterRecyclerBinding
import com.leobit.quwichat.ui.adapter.ChatAdapter
import com.leobit.quwichat.viewmodel.ChatViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import com.leobit.quwichat.network.Channel

class ChatRecyclerFragment : Fragment() {
    lateinit var chatViewModel:ChatViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        chatViewModel = ViewModelProvider(this).get(ChatViewModel::class.java)
        val binding = CharacterRecyclerBinding.inflate(inflater)


        val paginAdapter = ChatAdapter()
        binding.chatRecycler.adapter = paginAdapter

        lifecycleScope.launch {
            chatViewModel.flow.collectLatest { value: PagingData<Channel> ->
                paginAdapter.submitData(value)
            }
        }

      return binding.root
    }





}