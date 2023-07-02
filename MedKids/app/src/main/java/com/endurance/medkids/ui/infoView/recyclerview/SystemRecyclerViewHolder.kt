package com.endurance.medkids.ui.infoView.recyclerview


import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.endurance.medkids.network.dto.BodySystemModel
import com.endurance.medkids.databinding.ItemCardInfoBinding

class SystemRecyclerViewHolder (val binding: ItemCardInfoBinding) :
 RecyclerView.ViewHolder(binding.root){


     fun bind(system: BodySystemModel, clickListener: (BodySystemModel) -> Unit){
         binding.tittleCard.text = system.name

         binding.imgCard.setImageResource(system.section_image)

         binding.cardInfoView.setCardBackgroundColor(ContextCompat.getColor(binding.root.context, system.color))

         binding.cardInfoView.setOnClickListener {
             clickListener(system)
         }


     }
}