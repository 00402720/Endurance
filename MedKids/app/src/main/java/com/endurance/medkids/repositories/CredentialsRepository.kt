package com.endurance.medkids.repositories

import com.endurance.medkids.network.ApiResponse
import com.endurance.medkids.network.dto.createuser.CreateRequest
import com.endurance.medkids.network.dto.login.LoginRequest
import com.endurance.medkids.network.service.AuthService
import retrofit2.HttpException
import java.io.IOException

class CredentialsRepository(private val api: AuthService) {


    suspend fun login(email: String, password: String): ApiResponse<String> {
        try {
            val response = api.login(LoginRequest(email, password))
            return ApiResponse.Success(response.message)

        } catch (e: HttpException) {
            if (e.code() == 400) {
                return ApiResponse.ErrorWithMessage("Invalid email or password")
            }
            return ApiResponse.Error(e)
        } catch (e: IOException) {
            return ApiResponse.Error(e)
        }
    }



    suspend fun createUser(username: String, email: String, password: String): ApiResponse<String> {

        try {
            val response = api.createUser(CreateRequest(username, email, password))
            return ApiResponse.Success(response.username)
        } catch (e: HttpException) {
            if (e.code() == 400){
                return  ApiResponse.ErrorWithMessage("Please provide username, email, and password")
            }
            return  ApiResponse.Error(e)

        }catch (e: IOException){
            return ApiResponse.Error(e)
        }
    }
}