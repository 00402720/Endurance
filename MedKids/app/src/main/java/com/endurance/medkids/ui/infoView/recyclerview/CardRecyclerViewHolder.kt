package com.endurance.medkids.ui.infoView.recyclerview

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.endurance.medkids.data.model.CardInfoModel
import com.endurance.medkids.databinding.ItemCardInfoBinding

class CardRecyclerViewHolder (val binding: ItemCardInfoBinding) :
 RecyclerView.ViewHolder(binding.root){

     fun bind(card: CardInfoModel, clickListener: (CardInfoModel) -> Unit){

         binding.tittleCard.text = card.tittle
         binding.imgCard.setImageResource(card.img)
         // Establecer el color de fondo de la CardView
         binding.cardInfoView.setCardBackgroundColor(ContextCompat.getColor(binding.root.context, card.color))

         binding.cardInfoView.setOnClickListener {
             clickListener(card)
         }
     }
}