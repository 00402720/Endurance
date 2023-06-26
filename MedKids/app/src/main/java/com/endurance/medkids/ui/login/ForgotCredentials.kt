package com.endurance.medkids.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.endurance.medkids.R
import com.endurance.medkids.databinding.FragmentForgotCredentialsBinding

class ForgotCredentials : Fragment() {

    private lateinit var binding: FragmentForgotCredentialsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForgotCredentialsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnCredentialsToLoading.setOnClickListener {
            it.findNavController().navigate(R.id.action_forgotCredentials_to_loginView)
        }
    }
}