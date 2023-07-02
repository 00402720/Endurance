package com.endurance.medkids.network.dto

data class UserModel(
    val username: String,
    val email: String,
    val password: String,
    val points: Int
)
