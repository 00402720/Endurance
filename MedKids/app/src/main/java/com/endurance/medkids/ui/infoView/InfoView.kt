package com.endurance.medkids.ui.infoView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.endurance.medkids.data.model.CardInfoModel
import com.endurance.medkids.databinding.FragmentInfoViewBinding
import com.endurance.medkids.ui.infoView.recyclerview.CardRecyclerViewAdapter
import com.endurance.medkids.ui.infoView.viewmodels.CardViewModel


class InfoView : Fragment() {

    private val cardInfoViewModel: CardViewModel by activityViewModels{
        CardViewModel.Factory
    }


    private lateinit var binding: FragmentInfoViewBinding

    private lateinit var adapter: CardRecyclerViewAdapter

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

    private fun showSelectedItem(card : CardInfoModel){
        cardInfoViewModel.setSelectedCard(card)
    }
    private fun displayCard(){
        adapter.setData(cardInfoViewModel.getCards())
        adapter.notifyDataSetChanged()
    }

    private fun setRecyclerView(view: View){
        binding.cardItemView.layoutManager = LinearLayoutManager(view.context)
        adapter = CardRecyclerViewAdapter {
            selectedCard ->
            showSelectedItem(selectedCard)
        }
        binding.cardItemView.adapter = adapter
        displayCard()
    }


}