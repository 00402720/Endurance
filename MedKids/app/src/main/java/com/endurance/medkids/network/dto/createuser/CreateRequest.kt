package com.endurance.medkids.network.dto.createuser

data class CreateRequest(
    val username: String,
    val email: String,
    val password: String,
)


