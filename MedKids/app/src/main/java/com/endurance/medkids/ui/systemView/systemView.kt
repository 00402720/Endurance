package com.endurance.medkids.ui.systemView

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.endurance.medkids.R

import com.endurance.medkids.databinding.FragmentSystemViewBinding

class systemView : Fragment() {

    private lateinit var binding: FragmentSystemViewBinding
    private lateinit var mDialog: Dialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSystemViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mDialog = Dialog(requireContext())

        binding.floatingActionInfoSightNose.setOnClickListener {
            mDialog.setContentView(R.layout.infosightnose)
            mDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            mDialog.show()
        }
    }
}