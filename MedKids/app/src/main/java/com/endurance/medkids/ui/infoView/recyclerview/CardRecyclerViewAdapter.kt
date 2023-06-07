package com.endurance.medkids.ui.infoView.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.endurance.medkids.data.model.CardInfoModel
import com.endurance.medkids.databinding.ItemCardInfoBinding

class CardRecyclerViewAdapter(private val clickListener: (CardInfoModel) -> Unit) :
    RecyclerView.Adapter<CardRecyclerViewHolder>() {

    private val cards = ArrayList<CardInfoModel>()

    fun setData(cardList: List<CardInfoModel>){
        cards.clear()
        cards.addAll(cardList)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardRecyclerViewHolder {
        val binding =
            ItemCardInfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardRecyclerViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return cards.size
    }

    override fun onBindViewHolder(holder: CardRecyclerViewHolder, position: Int) {
        val card = cards[position]
        holder.bind(card, clickListener)

    }
    }
