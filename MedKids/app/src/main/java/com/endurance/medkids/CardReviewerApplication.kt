package com.endurance.medkids

import android.app.Application
import com.endurance.medkids.data.cards
import com.endurance.medkids.repositories.CardInfoRepository

class CardReviewerApplication : Application() {
    val cardInfoRepository: CardInfoRepository by lazy {
        CardInfoRepository(cards)
    }
}