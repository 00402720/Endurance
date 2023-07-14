package com.endurance.medkids.ui.systemView

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.activityViewModels
import com.bumptech.glide.Glide

import com.endurance.medkids.R
import com.endurance.medkids.databinding.FragmentSystemViewBinding
import com.endurance.medkids.ui.infoView.viewmodels.SystemViewModel

class SystemView : Fragment() {

    private val systemViewModel: SystemViewModel by activityViewModels {
        SystemViewModel.Factory
    }
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
        binding.btninfoSightLarynx.setOnClickListener {
            mDialog.setContentView(R.layout.infosightlarynx)
            mDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            mDialog.show()
        }
        binding.btninfosightAlveoli.setOnClickListener {
            mDialog.setContentView(R.layout.infosightalveoli)
            mDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            mDialog.show()
        }
        binding.btninfosightlungs.setOnClickListener {
            mDialog.setContentView(R.layout.infosightlungs)
            mDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            mDialog.show()
        }
        binding.btnsightBronchi.setOnClickListener {
            mDialog.setContentView(R.layout.infosightbronchi)
            mDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            mDialog.show()
        }
        binding.btninfosightTrachea.setOnClickListener {
            mDialog.setContentView(R.layout.infosighttrachea)
            mDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            mDialog.show()
        }
        binding.btninfosightPharynx.setOnClickListener {
            mDialog.setContentView(R.layout.infosightpharynx)
            mDialog.window!!.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            mDialog.show()
        }




        setViewModel()

    }



    private fun setViewModel() {
        binding.viewmodel = systemViewModel

        val imageView: ImageView? = binding.imagePuzzleImg

        // Observa los cambios en la propiedad puzzle_image en el ViewModel
        systemViewModel.puzzle_image.observe(viewLifecycleOwner) { imageResId ->
            // Verifica si el valor de puzzle_image no es nulo
            if (imageResId != null) {
                if (imageView != null) {
                    Glide.with(this)
                        .load(imageResId)
                        .into(imageView)
                }
            }
        }
    }
 }











