package com.endurance.medkids.ui.profile

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.endurance.medkids.RetrofitApplication
import com.endurance.medkids.databinding.FragmentProfileBinding

class perfil : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    val app by lazy {
        requireActivity().application as RetrofitApplication
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }


}