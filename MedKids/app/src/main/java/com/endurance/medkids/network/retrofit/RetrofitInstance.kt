package com.endurance.medkids.network.retrofit

import com.endurance.medkids.network.service.AuthService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory



const val BASE_URL = "https://thefashionlab-sv.com/"

object RetrofitInstance {

    private var token = ""


    fun setToken(token: String) {
        this.token = token
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun getLoginService(): AuthService {
        return retrofit.create(AuthService::class.java)
    }
}

