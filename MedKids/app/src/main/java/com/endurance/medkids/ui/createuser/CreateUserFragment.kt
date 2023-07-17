package com.endurance.medkids.ui.createuser

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.endurance.medkids.R
import com.endurance.medkids.databinding.FragmentSignUpBinding
import com.endurance.medkids.ui.createuser.viewmodel.CreateUserViewModel

class CreateUserFragment : Fragment() {

    private val createUserViewModel: CreateUserViewModel by activityViewModels {
        CreateUserViewModel.Factory
    }

    private lateinit var binding: FragmentSignUpBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setViewModel()
        observeStatus()

        binding.btnReturnToMain.setOnClickListener {
            it.findNavController().navigate(R.id.action_sign_Up_to_loadingView)
        }


    }

    private fun setViewModel() {
        binding.viewmodel = createUserViewModel
    }


    private fun observeStatus() {
        createUserViewModel.status.observe(viewLifecycleOwner) { status ->
            handleUiStatus(status)
        }
    }


    private fun handleUiStatus(status: CreateUserUIStatus) {
        when (status) {
            is CreateUserUIStatus.Error -> {
                Toast.makeText(requireContext(), "An error has occurred", Toast.LENGTH_SHORT).show()
            }

            is CreateUserUIStatus.ErrorWithMessage -> {
                Toast.makeText(requireContext(), status.message, Toast.LENGTH_SHORT).show()
            }

            is CreateUserUIStatus.Success -> {
                createUserViewModel.clearStatus()

                createUserViewModel.clearData()

                findNavController().navigate(R.id.action_sign_Up_to_loadingView)
            }

            else -> {}
        }
    }
}