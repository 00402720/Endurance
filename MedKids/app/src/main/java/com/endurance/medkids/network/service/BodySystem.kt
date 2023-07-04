package com.endurance.medkids.network.service

import com.endurance.medkids.network.dto.BodySystemModel
import retrofit2.Call
import retrofit2.http.GET

interface BodySystem {

    @GET("api/body-system")
    fun getBodySystem(): Call<BodySystemModel>
}