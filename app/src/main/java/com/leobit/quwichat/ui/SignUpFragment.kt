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
import com.leobit.quwichat.databinding.SignInFragmentBinding
import com.leobit.quwichat.databinding.SignUpFragmentBinding
import com.leobit.quwichat.network.CallsToApi
import com.leobit.quwichat.network.LoginResponse
import com.leobit.quwichat.viewmodel.TokenViewModel
import kotlinx.coroutines.launch
import java.lang.Exception

class SignUpFragment : Fragment() {

    lateinit var signUpBinding: SignUpFragmentBinding
    lateinit var tokenViewModel: TokenViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        signUpBinding = SignUpFragmentBinding.inflate(inflater)
        tokenViewModel = ViewModelProvider(this).get(TokenViewModel::class.java)


        signUpBinding.signUpBtn.setOnClickListener {

            lifecycleScope.launch {
                try {
                    tokenViewModel.signUp(
                        signUpBinding.name.text.toString(),
                        signUpBinding.email.text.toString(),
                        signUpBinding.password.text.toString()
                    )
                    val action =
                        SignUpFragmentDirections.actionSignUpFragmentToChatRecyclerFragment()
                    it.findNavController().navigate(action)
                } catch (e: Exception) {
                    Log.e("LogError", "this user already exist")

                }
            }
        }
        signUpBinding.loginR.setOnClickListener {
            val action = SignUpFragmentDirections.actionSignUpFragmentToSignInFragment()
            it.findNavController().navigate(action)
        }

        return signUpBinding.root


    }
}


