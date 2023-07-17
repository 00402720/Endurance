package com.endurance.medkids.ui.createuser

import java.lang.Exception

sealed class CreateUserUIStatus {

    object Resume : CreateUserUIStatus()

    data class ErrorWithMessage(val message: String) : CreateUserUIStatus()

    data class Error(val exception: Exception) : CreateUserUIStatus()

    object Success: CreateUserUIStatus()

}