package com.endurance.medkids.network.service

import com.endurance.medkids.network.dto.BodySystemModel
import com.endurance.medkids.network.dto.createuser.CreateRequest
import com.endurance.medkids.network.dto.createuser.CreateResponse
import com.endurance.medkids.network.dto.login.LoginRequest
import com.endurance.medkids.network.dto.login.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT

interface AuthService {

        @GET("api/body-system")
        fun getBodySystem(): Call<BodySystemModel>


        @POST("api/user/create")
        suspend fun createUser(@Body credentials: CreateRequest): CreateResponse

        @POST("api/user")
        suspend fun login(@Body credentials: LoginRequest): LoginResponse


}