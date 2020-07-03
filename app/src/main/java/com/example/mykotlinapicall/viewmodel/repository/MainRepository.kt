package com.example.mykotlinapicall.viewmodel.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.mykotlinapicall.AppApplication
import com.example.mykotlinapicall.manager.RetrofitManager
import com.example.mykotlinapicall.model.User
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class MainRepository {
    private val apiService = RetrofitManager.apiService

    val userSuccessLiveData = MutableLiveData<MutableList<User>>()
    val usersFailureLiveData = MutableLiveData<Boolean>()

    suspend fun getUser() {
        try {
            val response = apiService.getUser()

            if(response.isSuccessful) {
                userSuccessLiveData.postValue(response.body())
            }else {
                usersFailureLiveData.postValue(true)
            }
        } catch (e: UnknownHostException) {
            Log.e(TAG, e.message)
            //this exception occurs when there is no internet connection or host is not available
            //so inform user that something went wrong
            usersFailureLiveData.postValue(true)
        } catch (e: SocketTimeoutException) {
            Log.e(TAG, e.message)
            //this exception occurs when time out will happen
            //so inform user that something went wrong
            usersFailureLiveData.postValue(true)
        } catch (e: Exception) {
            Log.e(TAG, e.message)
            //this is generic exception handling
            //so inform user that something went wrong
            usersFailureLiveData.postValue(true)
        }
    }

    companion object {
        val TAG = MainRepository::class.java.simpleName
    }
}