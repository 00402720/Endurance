package com.endurance.medkids.network.dto.createuser

import com.google.gson.annotations.SerializedName

data class CreateResponse(
    @SerializedName("token") val token: String,


)