package com.endurance.medkids.ui.infoView.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.endurance.medkids.data.model.BodySystemModel
import com.endurance.medkids.databinding.ItemCardInfoBinding

class SystemRecyclerViewAdapter(private val clickListener: (BodySystemModel) -> Unit) :
    RecyclerView.Adapter<SystemRecyclerViewHolder>() {

    private val systems = ArrayList<BodySystemModel>()

    fun setData(systemList: List<BodySystemModel>){
        systems.clear()
        systems.addAll(systemList)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SystemRecyclerViewHolder {
        val binding =
            ItemCardInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SystemRecyclerViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return systems.size
    }

    override fun onBindViewHolder(holder: SystemRecyclerViewHolder, position: Int) {
        val system = systems[position]
        holder.bind(system, clickListener)

    }
    }
