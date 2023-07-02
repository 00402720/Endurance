package com.endurance.medkids.ui.infoView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.endurance.medkids.R
import com.endurance.medkids.network.dto.BodySystemModel
import com.endurance.medkids.databinding.FragmentInfoViewBinding
import com.endurance.medkids.ui.infoView.recyclerview.SystemRecyclerViewAdapter
import com.endurance.medkids.ui.infoView.viewmodels.SystemViewModel


class InfoView : Fragment() {

    private val systemViewModel: SystemViewModel by activityViewModels{
        SystemViewModel.Factory
    }


    private lateinit var binding: FragmentInfoViewBinding

    private lateinit var adapter: SystemRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
      binding = FragmentInfoViewBinding.inflate(inflater,container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRecyclerView(view)

    }

    private fun showSelectedItem(system : BodySystemModel){
        systemViewModel.setSelectedSystem(system)
        findNavController().navigate(R.id.action_infoView_to_systemView)
    }
    private fun displaySystem(){
        adapter.setData(systemViewModel.getSystems())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View){
        binding.cardItemView.layoutManager = LinearLayoutManager(view.context)
        adapter = SystemRecyclerViewAdapter {
            selectedSystem ->
            showSelectedItem(selectedSystem)
        }
        binding.cardItemView.adapter = adapter
        displaySystem()
    }


}