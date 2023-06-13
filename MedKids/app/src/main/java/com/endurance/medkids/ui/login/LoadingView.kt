package com.endurance.medkids.ui.login


import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.endurance.medkids.R
import com.endurance.medkids.databinding.FragmentLoadingViewBinding


class LoadingView : Fragment() {

    private lateinit var binding: FragmentLoadingViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Aplicar el tema sin ActionBar
        requireActivity().setTheme(com.endurance.medkids.R.style.Base_Theme_MedKids_NoActionBar)

        binding = FragmentLoadingViewBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        requireActivity().actionBar?.hide()

        binding.btnLoginLoadingView.setOnClickListener {
            it.findNavController().navigate(R.id.action_loadingView_to_loginView)
        }
    }
}

