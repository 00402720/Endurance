package com.endurance.medkids.network.dto.login

import com.google.gson.annotations.SerializedName

data class LoginResponse (
    @SerializedName("token") val token: String
)