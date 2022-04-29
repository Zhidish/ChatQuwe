package com.leobit.quwichat.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.paging.PagingData
import com.leobit.quwichat.databinding.SignInFragmentBinding
import com.leobit.quwichat.network.Channel
import com.leobit.quwichat.other.Const
import com.leobit.quwichat.viewmodel.TokenViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SignInFragment : Fragment(){
    lateinit var signInBinding:SignInFragmentBinding
    lateinit var tokenViewModel: TokenViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        signInBinding = SignInFragmentBinding.inflate(inflater)
        tokenViewModel = ViewModelProvider(this).get(TokenViewModel::class.java)
        signInBinding.signUpR.setOnClickListener{
            val action  = SignInFragmentDirections.actionSignInFragmentToSignUpFragment()
            it.findNavController().navigate(action)
        }


        signInBinding.loginBtn.setOnClickListener{
            try {
                var token: String? = null
                lifecycleScope.launch {
                    token = tokenViewModel.getToken(
                        signInBinding.editTextTextPersonName.text.toString(),
                        signInBinding.editTextTextPassword.text.toString()
                    )
                    Const.token = token
                    val action =
                        SignInFragmentDirections.actionSignInFragmentToChatRecyclerFragment()
                    it.findNavController().navigate(action)
                }
            } catch (e: Exception) {
                Log.e("LogError", "Invalid Values")

            }
        }

       return signInBinding.root
    }


}