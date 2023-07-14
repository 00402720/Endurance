package com.endurance.medkids.ui.infoView


import android.os.Bundle
import android.view.LayoutInflater

import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.endurance.medkids.R
import com.endurance.medkids.RetrofitApplication

import com.endurance.medkids.databinding.FragmentContentViewBinding


class ContentView : Fragment() {



    private lateinit var binding: FragmentContentViewBinding

    val app by lazy{
        requireActivity().application as  RetrofitApplication
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

       binding = FragmentContentViewBinding.inflate(inflater, container, false )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cardViewLearnAbout.setOnClickListener {
           it.findNavController().navigate(R.id.action_contentView_to_infoView)
        }

        binding.testYourKnowledge?.setOnClickListener{
            it.findNavController().navigate(R.id.action_contentView_to_levels)
        }
}


}