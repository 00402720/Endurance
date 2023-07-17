package com.endurance.medkids.ui.createuser.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.endurance.medkids.RetrofitApplication
import com.endurance.medkids.network.ApiResponse
import com.endurance.medkids.repositories.CredentialsRepository
import com.endurance.medkids.ui.createuser.CreateUserUIStatus
import kotlinx.coroutines.launch

class CreateUserViewModel(private val repository: CredentialsRepository) : ViewModel() {
    var username = MutableLiveData("")
    var email = MutableLiveData("")
    var password = MutableLiveData("")

    private val _status = MutableLiveData<CreateUserUIStatus>(CreateUserUIStatus.Resume)

    val status: LiveData<CreateUserUIStatus>
        get() = _status

    private fun createUser(username: String, email: String, password: String) {
        viewModelScope.launch {
            _status.postValue(
                when (val response = repository.createUser(username, email, password)) {
                    is ApiResponse.Error -> CreateUserUIStatus.Error(response.exception)
                    is ApiResponse.ErrorWithMessage -> CreateUserUIStatus.ErrorWithMessage(response.message)
                    is ApiResponse.Success -> CreateUserUIStatus.Success
                }
            )
        }
    }

    fun onCreateUser() {
        if (!validateData()) {
            _status.value = CreateUserUIStatus.ErrorWithMessage("Wrong information")
            return
        }
        createUser(username.value!!, email.value!!, password.value!!)
    }

    private fun validateData(): Boolean {
        when {
            username.value.isNullOrEmpty() -> return false
            email.value.isNullOrEmpty() -> return false
            password.value.isNullOrEmpty() -> return false
        }
        return true
    }
    fun clearStatus() {
        _status.value = CreateUserUIStatus.Resume
    }

    fun clearData() {
        username.value = ""
        email.value = ""
        password.value = ""
    }

    companion object {
        val Factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as RetrofitApplication
                CreateUserViewModel(app.credentialsRepository)
            }
        }
    }


}