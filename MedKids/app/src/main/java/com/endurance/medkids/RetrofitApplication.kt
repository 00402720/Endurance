package com.endurance.medkids

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.endurance.medkids.network.retrofit.RetrofitInstance
import com.endurance.medkids.repositories.CredentialsRepository

class RetrofitApplication : Application() {
    private val prefs: SharedPreferences by lazy {
        getSharedPreferences("Retrofit", Context.MODE_PRIVATE)
    }


    private fun getAPIService() = with(RetrofitInstance) {
        setToken(getToken())
        getLoginService()
    }

    fun getToken(): String = prefs.getString(USER_TOKEN, "")!!

    val credentialsRepository: CredentialsRepository by lazy {
        CredentialsRepository(getAPIService())
    }

    fun saveAuthToken(token: String) {
        val editor = prefs.edit()
        editor.putString(USER_TOKEN, token)
        editor.apply()
    }

    companion object {
        const val USER_TOKEN = "user_token"
    }


}

