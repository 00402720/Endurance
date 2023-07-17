package com.endurance.medkids.network.data

import com.endurance.medkids.R
import com.endurance.medkids.network.dto.BodySystemModel



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
    BodySystemModel(tittle, R.drawable.pulmones, R.drawable.sistema_respiratorio, R.color.card_respiratory),
    BodySystemModel(tittle1, R.drawable.estoma, R.drawable.sistemadigestivo, R.color.card_estomago),
    BodySystemModel(tittle2, R.drawable.vejiga, R.drawable.sistema_urinario, R.color.card_vejiga),
    BodySystemModel(tittle3, R.drawable.cerebro,R.drawable.sistemanervioso, R.color.card_cerebro)


)

