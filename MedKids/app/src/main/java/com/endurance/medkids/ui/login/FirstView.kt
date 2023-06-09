package com.endurance.medkids.ui.login

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.endurance.medkids.R
import com.endurance.medkids.databinding.FragmentFirstViewBinding



    class FirstView : Fragment() {
        private lateinit var binding: FragmentFirstViewBinding

        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            binding = FragmentFirstViewBinding.inflate(inflater, container, false)
            val view = binding.root
            // Agrega la siguiente línea para obtener el NavController


            Handler(Looper.myLooper()!!).postDelayed({
                val navOptions = NavOptions.Builder()
                    .setEnterAnim(R.anim.slide_in_bottom) // Animación de entrada desde abajo
                    .setExitAnim(R.anim.fade_out) // Animación de salida con desvanecimiento
                    .build()


            }, 3000)

            return view
        }
    }
