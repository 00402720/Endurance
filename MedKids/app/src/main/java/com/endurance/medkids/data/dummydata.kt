package com.endurance.medkids.data

import com.endurance.medkids.R
import com.endurance.medkids.data.model.CardInfoModel


val tittle = "Respiratory System"
val tittle1 = "Digestive System"
val tittle2 = "Urinary System"
val tittle3 = "Nervous System"


var cards = mutableListOf(
    CardInfoModel(tittle, R.drawable.pulmones, R.color.card_respiratory),
    CardInfoModel(tittle1, R.drawable.estoma, R.color.card_estomago),
    CardInfoModel(tittle2, R.drawable.vejiga, R.color.card_vejiga),
    CardInfoModel(tittle3, R.drawable.cerebro, R.color.card_cerebro),

)