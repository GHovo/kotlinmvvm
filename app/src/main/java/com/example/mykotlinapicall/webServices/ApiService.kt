package com.example.mykotlinapicall.webServices

import androidx.lifecycle.MutableLiveData
import com.example.mykotlinapicall.model.User
import com.example.mykotlinapicall.utils.Constants
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET(Constants.GET_USERS)
    suspend fun getUser() : Response<MutableList<User>>
}