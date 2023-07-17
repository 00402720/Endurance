package com.endurance.medkids.ui.login

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
import com.endurance.medkids.RetrofitApplication

import com.endurance.medkids.databinding.FragmentLoginViewBinding
import com.endurance.medkids.ui.login.viewmodel.LoginViewModel

class LoginView : Fragment() {

    private val loginViewModel: LoginViewModel by activityViewModels {
        LoginViewModel.Factory
    }

    private lateinit var binding: FragmentLoginViewBinding

    val app by lazy {
        requireActivity().application as RetrofitApplication
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        setViewModel()
        observeStatus()
        /*binding.btnLogin.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginView_to_contentView)
        }*/
        binding.btnReturn.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginView_to_loadingView)
        }

        binding.fgtPasswrdBtn.setOnClickListener {
            it.findNavController().navigate(R.id.action_loginView_to_forgotCredentials)
        }
    }

    private fun setViewModel() {
        binding.viewmodel = loginViewModel
    }
    private fun observeStatus() {
        loginViewModel.status.observe(viewLifecycleOwner) {
            status -> handleUiStatus(status)
        }
    }

   private fun handleUiStatus(status: LoginUiStatus) {
        val preferences =
        when (status) {
            is LoginUiStatus.Error -> {
                Toast.makeText(requireContext(), "Wrong information", Toast.LENGTH_SHORT).show()
            }

            is LoginUiStatus.ErrorWithMessage -> {
                Toast.makeText(requireContext(), status.message, Toast.LENGTH_SHORT).show()
            }

            is LoginUiStatus.Success -> {
                loginViewModel.clearStatus()
                loginViewModel.clearData()
                app.saveAuthToken(status.token)
                findNavController().navigate(R.id.action_loginView_to_contentView)

            }

            else -> {}
        }
    }

}