package com.endurance.medkids.repositories

import com.endurance.medkids.data.model.CardInfoModel

class CardInfoRepository( private val cards: MutableList<CardInfoModel>){

    fun getCards() = cards


}