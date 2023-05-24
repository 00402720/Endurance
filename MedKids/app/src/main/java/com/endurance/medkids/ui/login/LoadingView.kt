package com.endurance.medkids.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.endurance.medkids.R
import com.endurance.medkids.databinding.FragmentLoadingViewBinding

class LoadingView : Fragment() {


    private lateinit var binding: FragmentLoadingViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoadingViewBinding.inflate(inflater, container, false)
        return binding.root
    }


}