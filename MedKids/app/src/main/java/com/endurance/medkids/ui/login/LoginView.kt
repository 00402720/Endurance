package com.endurance.medkids.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.endurance.medkids.R

import com.endurance.medkids.databinding.FragmentLoginViewBinding

class LoginView : Fragment() {


   private lateinit var binding: FragmentLoginViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        binding.btnLogin.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginView_to_contentView)
        }
    }

}