package com.example.mykotlinapicall.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mykotlinapicall.viewmodel.repository.MainRepository
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val mainRepository = MainRepository()
    val usersSuccessLiveData = mainRepository.userSuccessLiveData
    val usersFailureLiveData = mainRepository.usersFailureLiveData

    fun getUsers() {
        viewModelScope.launch { mainRepository.getUser() }
    }
}