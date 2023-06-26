package com.endurance.medkids.data

import com.endurance.medkids.R
import com.endurance.medkids.data.model.BodySystemModel



val tittle = "Respiratory System"
val tittle1 = "Digestive System"
val tittle2 = "Urinary System"
val tittle3 = "Nervous System"




val lungsImage = "pulmones.png"
val estomaImage = "drawable/estoma.png"
val vejigaImage = "drawable/vejiga.png"
val cerebroImage = "drawable/cerebro.png"

val systemRespiratory = "drawable/sistema_respiratorio.png"
val systemUrinary = "drawable/sistema_urinario.png"



var systems = mutableListOf(
    BodySystemModel(tittle, lungsImage, systemRespiratory, R.color.card_respiratory),
    BodySystemModel(tittle1, estomaImage, systemUrinary, R.color.card_estomago),
    BodySystemModel(tittle2, vejigaImage, systemRespiratory, R.color.card_vejiga),
    BodySystemModel(tittle3, cerebroImage,systemUrinary, R.color.card_cerebro)


)

